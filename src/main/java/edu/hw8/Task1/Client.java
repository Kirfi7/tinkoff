package edu.hw8.Task1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Client implements Runnable {
    private final static String HOST = "localhost";
    private final static int PORT = 8080;
    private final static String EXIT_WORD = "exit";
    private final Logger logger = LogManager.getLogger();

    @Override
    public void run() {
        try (Socket clientSocket = new Socket(HOST, PORT);
             BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)
        ) {
            while (true) {
                logger.info(String.format("Введите ключевое слово (для выхода введите '%s'):%n", EXIT_WORD));
                String keyword = scanner.nextLine();

                if (keyword.equalsIgnoreCase(EXIT_WORD)) {
                    return;
                }

                writer.println(keyword);
                String response = reader.readLine();
                logger.info(String.format("Сервер: %s%n", response));
            }
        } catch (Exception e) {
            throw new RuntimeException(Arrays.toString(e.getStackTrace()));
        }
    }
}
