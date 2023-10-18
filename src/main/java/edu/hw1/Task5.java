package edu.hw1;

public class Task5 {

    // Значение конфигурации для проверки наследника числа
    private static final int CONFIG_VALUE = 10;

    private Task5() {
        // приватный конструктор
    }

    // Метод для определения того, является ли число или его наследник палиндромом
    public static boolean isPalindromeDescendant(int number) {
        int currentNumber = number;
        while (currentNumber >= CONFIG_VALUE) {
            if (isPalindrome(currentNumber)) {
                return true;
            }
            currentNumber = getDescendant(currentNumber);
        }
        return false;
    }

    // Метод для проверки, является ли число палиндромом
    private static boolean isPalindrome(int number) {
        String str = Integer.toString(number);
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Метод для получения наследника числа
    private static int getDescendant(int number) {
        String str = Integer.toString(number);
        StringBuilder descendant = new StringBuilder();
        for (int i = 0; i < str.length() - 1; i += 2) {
            int digit1 = Character.getNumericValue(str.charAt(i));
            int digit2 = Character.getNumericValue(str.charAt(i + 1));
            descendant.append(digit1 + digit2);
        }
        return Integer.parseInt(descendant.toString());
    }
}
