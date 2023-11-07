package edu.hw5;

import java.util.regex.Pattern;

public class Task4 {
    private Task4() {
    }

    private final static String SPECIAL_CHARACTERS = "[~!@#\\$%^&*|]"; // Строка, представляющая специальные символы

    // Метод для проверки корректности пароля с использованием регулярного выражения
    public static boolean checkPasswordCorrectness(String password) {
        return Pattern.compile(SPECIAL_CHARACTERS).matcher(password).find();
        // Поиск совпадения специальных символов в пароле.
    }
}

