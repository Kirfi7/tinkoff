package edu.hw1;

public class ThirdTask {
    public static boolean isNestable(int[] array1, int[] array2) {
        if (array1.length == 0 || array2.length == 0) {
            return false;
        }

        int min1 = findMin(array1);
        int min2 = findMin(array2);
        int max1 = findMax(array1);
        int max2 = findMax(array2);

        return min1 > min2 && max1 < max2;
    }

    private static int findMin(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

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

