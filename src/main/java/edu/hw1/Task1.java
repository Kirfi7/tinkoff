package edu.hw1;

public class Task1 {

    private static final int CONFIG_VALUE = 60;

    private Task1() {
        // приватный конструктор
    }

    public static int minutesToSeconds(String time) {
        String[] parts = time.split(":");
        if (parts.length != 2) {
            return -1;
        }

        try {
            int minutes = Integer.parseInt(parts[0]);
            int seconds = Integer.parseInt(parts[1]);
            if (seconds >= CONFIG_VALUE) {
                return -1;
            }
            return minutes * CONFIG_VALUE + seconds;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
