package edu.hw5;

import java.util.regex.Pattern;

public class Task6 {
    private Task6() {
    }

    // Метод для определения, является ли одна строка подпоследовательностью другой
    public static boolean isSubsequence(String sequence, String subsequence) {
        String regex = ".*" + Pattern.quote(subsequence) + ".*";
        // Создание регулярного выражения для проверки подпоследовательности
        return Pattern.matches(regex, sequence); // Проверка совпадения подпоследовательности в строке
    }
}
