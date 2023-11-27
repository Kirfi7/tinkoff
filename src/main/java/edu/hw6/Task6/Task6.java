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

/**
 * Класс Task6 предоставляет статические методы для сканирования портов и определения их состояния (занят или свободен).
 */
public class Task6 {
    // Инициализация логгера Log4j
    private final static Logger LOGGER = LogManager.getLogger();

    // Приватный конструктор, чтобы предотвратить создание экземпляров класса
    private Task6() {
    }

    /**
     * Метод для получения информации о занятых портах, используя команду lsof в терминале.
     * Выводит информацию в лог с использованием Log4j.
     */
    public static void getBusyPortsInfo() {
        // Паттерны для выделения информации из вывода команды lsof
        Pattern portPattern = Pattern.compile(".{1,3}\\..{1,3}\\..{1,3}\\..{1,3}:\\d{1,}");
        Pattern protocolPattern = Pattern.compile("TCP|UDP");
        Pattern servicePattern = Pattern.compile("[A-z]*");

        try {
            // Запускаем процесс выполнения команды lsof
            Process process = Runtime.getRuntime().exec("lsof -i -n");
            // Читаем вывод команды
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = reader.readLine();

            // Обрабатываем каждую строку вывода
            while (line != null) {
                // Создаем матчеры для поиска порта, протокола и службы в строке
                Matcher portMatcher = portPattern.matcher(line);
                Matcher protocolMatcher = protocolPattern.matcher(line);
                Matcher serviceMatcher = servicePattern.matcher(line);

                // Если все три параметра найдены, выводим информацию в лог
                if (portMatcher.find() && protocolMatcher.find() && serviceMatcher.find()) {
                    String port = portMatcher.group().split(":")[1];
                    String protocol = protocolMatcher.group();
                    String service = serviceMatcher.group();

                    LOGGER.info(protocol + " " + port + " " + service);
                }

                line = reader.readLine();
            }

            // Ожидаем завершение процесса
            process.waitFor();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    /**
     * Метод для сканирования портов в диапазоне от minPort до maxPorts и вывода информации о состоянии портов в лог.
     *
     * @param minPort  Нижняя граница диапазона портов.
     * @param maxPorts Верхняя граница диапазона портов.
     */
    public static void getFreeAndBusyPorts(int minPort, int maxPorts) {
        // Обходим все порты в заданном диапазоне
        for (int port = minPort; port <= maxPorts; port++) {
            // Сканируем порт и выводим информацию в лог
            String status = scanPort(port);
            LOGGER.info(port + " " + status);
        }
    }

    /**
     * Метод для сканирования конкретного порта и определения его состояния (занят или свободен).
     *
     * @param port Порт для сканирования.
     * @return Строка, указывающая состояние порта ("Занят" или "Свободен").
     */
    public static String scanPort(int port) {
        try {
            // Регистрируем ServerSocket и DatagramSocket на заданном порту
            ServerSocket serverSocket = new ServerSocket(port);
            DatagramSocket ds = new DatagramSocket(port);
            // Закрываем сокеты после использования
            serverSocket.close();
            ds.close();
            // Если не было исключений, порт свободен
            return "Свободен";
        } catch (IOException e) {
            // Если было исключение, порт занят
            return "Занят";
        }
    }
}
