package edu.hw1;

import java.util.Arrays;

public class Task6 {

    // Константа, представляющая число Капрекара
    private static final int CONFIG_NUMBER = 6174;

    private Task6() {
        // приватный конструктор
    }

    // Метод для подсчета шагов до числа Капрекара
    public static int countK(int number) {
        // Если число уже равно константе CONFIG_NUMBER, то количество шагов равно 0
        if (number == CONFIG_NUMBER) {
            return 0;
        }

        // Преобразуем число в массив символов и сортируем его
        char[] digits = Integer.toString(number).toCharArray();
        Arrays.sort(digits);
        String ascending = new String(digits);

        // Создаем строку, представляющую отсортированные цифры в убывающем порядке
        String descending = new StringBuilder(ascending).reverse().toString();

        // Вычисляем разницу между числами в убывающем и возрастающем порядке
        int diff = Integer.parseInt(descending) - Integer.parseInt(ascending);

        // Рекурсивно вызываем метод, увеличивая счетчик шагов на 1
        return 1 + countK(diff);
    }
}

