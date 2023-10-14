package edu.hw1;

import java.util.Arrays;
public class SixthTask {
    public static int countK(int number) {
        if (number == 6174) {
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

