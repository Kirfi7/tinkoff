package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecondTaskTests {
    @Test
    public void testCountDigitsWithNonZeroNumber() {
        assertEquals(4, SecondTask.countDigits(4666));
        assertEquals(3, SecondTask.countDigits(544));
        assertEquals(5, SecondTask.countDigits(12345));
        assertEquals(7, SecondTask.countDigits(9876543));
    }

    @Test
    public void testCountDigitsWithZero() {
        assertEquals(1, SecondTask.countDigits(0));
    }
}

