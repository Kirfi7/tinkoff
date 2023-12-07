package edu.project3.terminal;

import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Terminal {
    private final static Logger LOGGER = LogManager.getLogger();
    private final static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final static int START_COMMANDS_COUNT = 4;
    private static Scanner scanner = new Scanner(System.in);

    private Terminal() {
    }

    public static Logger getLogger() {
        return LOGGER;
    }

    public static void setInputStream(InputStream inputStream) {
        scanner = new Scanner(inputStream);
    }

    public static TerminalRequest expectRequest() {
        while (true) {
            String request = scanner.nextLine();
            String[] commands = request.split("\\s+");

            if (!firstCommandsCorrectness(commands)) {
                continue;
            }

            int curInd = START_COMMANDS_COUNT;

            URI uri;
            try {
                uri = new URI(commands[curInd++]);
            } catch (URISyntaxException e) {
                LOGGER.error(String.format("Incorrect URI: %s", commands[curInd - 1]));
                continue;
            }

            LocalDate from = getDate(commands, "--from", curInd);
            if (from == LocalDate.MAX) {
                continue;
            } else if (from != null) {
                curInd += 2;
            }

            LocalDate to = getDate(commands, "--to", curInd);
            if (to == LocalDate.MAX) {
                continue;
            } else if (to != null) {
                curInd += 2;
            }

            TerminalRequest.ResultFormat format = null;
            if (curInd < commands.length - 1 && commands[curInd].equals("--format")) {
                curInd++;
                try {
                    format = Enum.valueOf(TerminalRequest.ResultFormat.class, commands[curInd++].toUpperCase());
                } catch (IllegalArgumentException e) {
                    LOGGER.error(String.format("Incorrect format '%s'", commands[curInd - 1]));
                    continue;
                }
            }

            if (curInd < commands.length) {
                LOGGER.error("unexpected command");
                continue;
            }

            return new TerminalRequest(uri, from, to, format);
        }
    }

    private static boolean firstCommandsCorrectness(String[] command) {
        if (command.length < START_COMMANDS_COUNT + 1) {
            LOGGER.error("Incorrect command count");
            return false;
        }

        int curInd = 0;

        return checkCommand(command[curInd++], "java")
            && checkCommand(command[curInd++], "-jar")
            && checkCommand(command[curInd++], "nginx-log-stats.jar")
            && checkCommand(command[curInd], "--path");
    }

    private static LocalDate getDate(String[] commands, String equals, int index) {
        int ind = index;
        if (ind < commands.length - 1 && commands[ind].equals(equals)) {
            ind++;
            try {
                return LocalDate.parse(commands[ind++], DATE_FORMATTER);
            } catch (DateTimeParseException e) {
                LOGGER.error(String.format("Incorrect date '%s'", commands[ind - 1]));
                return LocalDate.MAX;
            }
        }

        return null;
    }

    private static boolean checkCommand(String actual, String expected) {
        if (!actual.equals(expected)) {
            LOGGER.error(String.format("Command '%s' not found, did you mean '%s'", actual, expected));
            return false;
        }

        return true;
    }
}
