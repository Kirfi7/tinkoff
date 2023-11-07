package edu.hw5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Optional;

public class Task3 {
    private Task3() {
    }

    private final static DateTimeFormatter[] FORMATTERS = new DateTimeFormatter[] {
        DateTimeFormatter.ofPattern("yyyy-MM-dd"),
        DateTimeFormatter.ofPattern("dd-MM-yyyy"),
        DateTimeFormatter.ofPattern("dd-MM-yy")
    };

    private final static int COUNT_NUMBERS_IN_DATE = 3; // Константа, представляющая количество чисел в дате

    // Метод для разбора входной строки и получения объекта LocalDate
    public static Optional<LocalDate> parseDate(String input) {
        var inputForChange = input.replace("/", "-");

        // Замена слешей на дефисы и проверка формата даты
        if (inputForChange.contains("-")) {
            var s = inputForChange.split("-");
            if (s.length == COUNT_NUMBERS_IN_DATE && Arrays.stream(s).allMatch(x -> isInteger(x))) {
                for (var i = 0; i < s.length; i++) {
                    addZero(s, i);
                }

                inputForChange = String.join("-", s);
            }
        }

        // Проверка формата даты с использованием заранее заданных форматтеров
        for (DateTimeFormatter formatter : FORMATTERS) {
            Optional<LocalDate> date = tryParse(inputForChange, formatter);
            if (date.isPresent()) {
                return date;
            }
        }

        Optional<LocalDate> result = Optional.empty();

        // Обработка особых случаев
        switch (input) {
            case "today":
                result = Optional.of(LocalDate.now());
                break;
            case "tomorrow":
                result = Optional.of(LocalDate.now().plusDays(1));
                break;
            case "yesterday":
                result = Optional.of(LocalDate.now().minusDays(1));
                break;
            default:
                if (inputForChange.endsWith("ago")) {
                    result = Optional.of(LocalDate.now().minusDays(getIntegerFromString(inputForChange)));
                }
        }

        return result;
    }

    private static Optional<LocalDate> tryParse(String string, DateTimeFormatter formatter) {
        try {
            return Optional.of(LocalDate.parse(string, formatter));
        } catch (DateTimeParseException e) {
            return Optional.empty();
        }
    }

    // Вспомогательный метод для проверки, является ли строка целым числом
    static boolean isInteger(String str) {
        for (var i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    // Вспомогательный метод для добавления нуля к строке, если она представляет однозначное число
    static void addZero(String[] split, int index) {
        if (split[index].length() == 1) {
            split[index] = "0" + split[index];
        }
    }

    // Вспомогательный метод для извлечения целого числа из строки
    private static int getIntegerFromString(String input) {
        var index = 0;
        while (index < input.length() && Character.isDigit(input.charAt(index))) {
            index++;
        }

        return Integer.parseInt(input.substring(0, index));
    }
}

