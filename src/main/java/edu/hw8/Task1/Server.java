package edu.hw8.Task1;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server implements Runnable {
    private final static int PORT = 8080;
    private final static int MAX_CONNECTIONS = 5;

    @Override
    public void run() {
        try (
            ExecutorService executorService = Executors.newFixedThreadPool(MAX_CONNECTIONS);
            ServerSocket serverSocket = new ServerSocket(PORT)
        ) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                executorService.submit(new ClientHandler(clientSocket));
            }
        } catch (Exception e) {
            throw new RuntimeException(Arrays.toString(e.getStackTrace()));
        }
    }
}
