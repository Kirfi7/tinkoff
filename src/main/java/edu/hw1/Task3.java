package edu.hw1;

public class Task3 {

    private Task3() {
        // приватный конструктор
    }

    // Метод, который проверяет, являются ли элементы в array1 вложенными в элементы array2
    public static boolean isNestable(int[] array1, int[] array2) {
        // Проверка на пустые массивы
        if (array1.length == 0 || array2.length == 0) {
            return false;
        }

        // Находим минимальное и максимальное значение в каждом из массивов
        int min1 = findMin(array1);
        int min2 = findMin(array2);
        int max1 = findMax(array1);
        int max2 = findMax(array2);

        // Проверяем, вложены ли элементы первого массива в элементы второго массива
        return min1 > min2 && max1 < max2;
    }

    // Метод для нахождения минимального значения в массиве
    private static int findMin(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    // Метод для нахождения максимального значения в массиве
    private static int findMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}

