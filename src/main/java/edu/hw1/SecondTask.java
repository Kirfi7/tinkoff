package edu.hw1;

public class SecondTask {
    public static int countDigits(int number) {
        if (number == 0) {
            return 1;
        }
        int count = 0;
        while (number != 0) {
            number = number / 10;
            count++;
        }
        return count;
    }
}
