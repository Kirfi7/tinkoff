package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task6Tests {
    @Test
    public void testKaprekarFunctionWithDifferentExamples() {
        assertEquals(3, Task6.countK(3524));
        assertEquals(5, Task6.countK(6621));
        assertEquals(4, Task6.countK(6554));
        assertEquals(3, Task6.countK(1234));
    }

    @Test
    public void testCountKWith6174() {
        assertEquals(0, Task6.countK(6174));
    }

    @Test
    public void testCountKWithSmallestFourDigitNumber() {
        assertEquals(3, Task6.countK(1234));
    }

    @Test
    public void testCountKWithDescendingOrderNumber() {
        assertEquals(3, Task6.countK(9876));
    }

}

