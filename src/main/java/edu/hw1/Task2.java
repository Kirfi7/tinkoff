package edu.hw1;

public class Task2 {

    // Константа, используемая в делении числа
    private static final int CONFIG_VALUE = 10;

    private Task2() {
        // приватный конструктор
    }

    // Метод для подсчета количества цифр в заданном числе.
    public static int countDigits(int number) {
        int currentNumber = number;
        if (currentNumber == 0) {
            return 1;
        }
        int count = 0;
        while (currentNumber != 0) {
            currentNumber = currentNumber / CONFIG_VALUE;
            count++;
        }
        return count;
    }
}
