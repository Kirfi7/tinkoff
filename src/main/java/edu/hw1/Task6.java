package edu.hw1;

import java.util.Arrays;

public class Task6 {

    private static final int CONFIG_NUMBER = 6174;

    private Task6() {
        // приватный конструктор
    }

    public static int countK(int number) {
        if (number == CONFIG_NUMBER) {
            return 0;
        }

        char[] digits = Integer.toString(number).toCharArray();
        Arrays.sort(digits);
        String ascending = new String(digits);
        String descending = new StringBuilder(ascending).reverse().toString();
        int diff = Integer.parseInt(descending) - Integer.parseInt(ascending);
        return 1 + countK(diff);
    }
}

