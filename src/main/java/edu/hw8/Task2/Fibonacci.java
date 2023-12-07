package edu.hw8.Task2;

public class Fibonacci {
    private Fibonacci() {
    }

    public static void getFirstNumbers(int n, int threadsCount, int[] result) {
        if (result.length < n) {
            throw new IllegalArgumentException();
        }

        FixedThreadPool tp = new FixedThreadPool();
        tp.create(threadsCount);

        for (int i = 0; i < n; i++) {
            int finalI = i;
            tp.execute(() -> result[finalI] = get(finalI + 1));
        }
    }

    private static int get(int n) {
        int firstNum = 0;
        int secondNum = 1;
        int indexToCalculate = 2;

        while (indexToCalculate < n) {
            if (indexToCalculate++ % 2 == 0) {
                firstNum += secondNum;
            } else {
                secondNum += firstNum;
            }
        }

        return firstNum + secondNum;
    }
}
