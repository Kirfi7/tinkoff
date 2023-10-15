package edu.hw1;

public class Task1 {

    // Константа для конвертации минут в секунды
    private static final int CONFIG_VALUE = 60;

    private Task1() {
        // приватный конструктор
    }

    /**
    * Преобразует время из формата "минуты:секунды" в общее количество секунд.
    * Если формат времени некорректен или количество секунд больше или равно CONFIG_VALUE,
    * возвращает -1.
    */

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
