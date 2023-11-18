package edu.hw6.Task6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task6 {
    private final static Logger LOGGER = LogManager.getLogger();

    private Task6() {
    }

    public static void getBusyPortsInfo() {
        Pattern portPattern = Pattern.compile(".{1,3}\\..{1,3}\\..{1,3}\\..{1,3}:\\d{1,}");
        Pattern protocolPattern = Pattern.compile("TCP|UDP");
        Pattern servicePattern = Pattern.compile("[A-z]*");

        try {
            Process process = Runtime.getRuntime().exec("lsof -i -n");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = reader.readLine();

            while (line != null) {
                Matcher portMatcher = portPattern.matcher(line);
                Matcher protocolMatcher = protocolPattern.matcher(line);
                Matcher serviceMatcher = servicePattern.matcher(line);

                if (portMatcher.find() && protocolMatcher.find() && serviceMatcher.find()) {
                    String port = portMatcher.group().split(":")[1];
                    String protocol = protocolMatcher.group();
                    String service = serviceMatcher.group();

                    LOGGER.info(protocol + " " + port + " " + service);
                }

                line = reader.readLine();
            }

            process.waitFor();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static void getFreeAndBusyPorts(int minPort, int maxPorts) {
        for (int port = minPort; port <= maxPorts; port++) {
            String status = scanPort(port);
            LOGGER.info(port + " " + status);
        }
    }

    public static String scanPort(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            var ds = new DatagramSocket(port);
            serverSocket.close();
            ds.close();
            return "Свободен";
        } catch (IOException e) {
            return "Занят";
        }
    }
}
