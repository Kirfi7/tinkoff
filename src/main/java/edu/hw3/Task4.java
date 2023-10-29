package edu.hw3;

public class Task4 {

    // Приватный конструктор класса
    private Task4() {

    }

    // Максимальное значение для перевода в римскую систему
    private static final int MAX_ROMAN_NUMBER = 3999;

    // Делитель для тысяч в римской системе
    private static final int THOUSANDS_DIVIDER = 1000;

    // Делитель для сотен в римской системе
    private static final int HUNDREDS_DIVIDER = 100;

    // Делитель для десятков в римской системе
    private static final int TENS_DIVIDER = 10;

    /**
     * Метод преобразует целое число в римскую систему счисления.
     * Входное число должно быть в диапазоне от 1 до MAX_ROMAN_NUMBER.
     *
     * @param number Целое число для преобразования
     * @return Строковое представление числа в римской системе счисления
     * @throws IllegalArgumentException если входное число не в диапазоне от 1 до MAX_ROMAN_NUMBER
     */
    public static String convertToRoman(int number) {
        if (number < 1 || number > MAX_ROMAN_NUMBER) {
            throw new IllegalArgumentException("Число вне диапазона (от 1 до " + MAX_ROMAN_NUMBER + ")");
        }
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return thousands[number / THOUSANDS_DIVIDER]
            + hundreds[(number % THOUSANDS_DIVIDER) / HUNDREDS_DIVIDER]
            + tens[(number % HUNDREDS_DIVIDER) / TENS_DIVIDER]
            + ones[number % TENS_DIVIDER];
    }
}
