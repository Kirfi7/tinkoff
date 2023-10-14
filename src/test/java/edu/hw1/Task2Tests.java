package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Tests {
    @Test
    public void testCountDigitsWithNonZeroNumber() {
        assertEquals(4, Task2.countDigits(4666));
        assertEquals(3, Task2.countDigits(544));
        assertEquals(5, Task2.countDigits(12345));
        assertEquals(7, Task2.countDigits(9876543));
    }

    @Test
    public void testCountDigitsWithZero() {
        assertEquals(1, Task2.countDigits(0));
    }
}

