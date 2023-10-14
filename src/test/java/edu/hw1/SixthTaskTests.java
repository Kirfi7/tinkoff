package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SixthTaskTests {
    @Test
    public void testCountKWithExampleNumbers() {
        assertEquals(3, SixthTask.countK(3524));
        assertEquals(5, SixthTask.countK(6621));
        assertEquals(4, SixthTask.countK(6554));
        assertEquals(3, SixthTask.countK(1234));
    }

    @Test
    public void testCountKWith6174() {
        assertEquals(0, SixthTask.countK(6174));
    }
}

