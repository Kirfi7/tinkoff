package edu.hw3;

public final class Task1 {

    // Приватный конструктор
    private Task1() {

    }

    // Метод для преобразования строки по правилам шифра Атбаш
    public static String atbash(String input) {
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            // Проверяем, является ли символ буквой
            if (Character.isLetter(c)) {
                // Если буква - проверяем, является ли она заглавной
                if (Character.isUpperCase(c)) {
                    // Добавляем в результат преобразованную букву шифра Атбаш для заглавных букв
                    result.append((char) ('Z' - (c - 'A')));
                } else {
                    // Добавляем в результат преобразованную букву шифра Атбаш для строчных букв
                    result.append((char) ('z' - (c - 'a')));
                }
            } else {
                // Если символ не является буквой, добавляем его в результат как есть
                result.append(c);
            }
        }
        // Возвращаем результат в виде строки
        return result.toString();
    }
}
