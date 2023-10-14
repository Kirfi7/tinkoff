package edu.hw1;

public class Task4 {

    private Task4() {
        // приватный конструктор
    }

    static String fixString(String str) {
        if (str == null || str.length() % 2 != 0) {
            return "Invalid Input";
        }

        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i += 2) {
            char temp = charArray[i];
            charArray[i] = charArray[i + 1];
            charArray[i + 1] = temp;
        }

        return new String(charArray);
    }
}
