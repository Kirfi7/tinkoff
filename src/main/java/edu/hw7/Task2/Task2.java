package edu.hw7.Task2;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class Task2 {
    private Task2() {
    }

    public static BigInteger getFactorial(byte n) {
        return LongStream.rangeClosed(1, n)
            .parallel()
            .mapToObj(BigInteger::valueOf)
            .reduce(BigInteger.ONE, BigInteger::multiply);
    }
}

