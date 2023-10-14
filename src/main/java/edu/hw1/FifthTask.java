package edu.hw1;

public class FifthTask {
    public static boolean isPalindromeDescendant(int number) {
        while (number >= 10) {
            if (isPalindrome(number)) {
                return true;
            }
            number = getDescendant(number);
        }
        return false;
    }

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
