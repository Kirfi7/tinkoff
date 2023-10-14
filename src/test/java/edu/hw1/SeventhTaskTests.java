package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeventhTaskTests {

    @Test
    public void testRotateRight() {
        assertEquals(4, SeventhTask.rotateRight(8, 1));
        assertEquals(8, SeventhTask.rotateRight(16, 6));
        assertEquals(12, SeventhTask.rotateRight(17, 2));
    }

    @Test
    public void testRotateLeft() {
        assertEquals(4, SeventhTask.rotateLeft(8, 31));
        assertEquals(1, SeventhTask.rotateLeft(16, 6));
        assertEquals(6, SeventhTask.rotateLeft(17, 2));
    }

    @Test
    public void testRotateWithZeroShift() {
        assertEquals(8, SeventhTask.rotateRight(8, 0));
        assertEquals(16, SeventhTask.rotateLeft(16, 0));
        assertEquals(17, SeventhTask.rotateLeft(17, 0));
    }

    @Test
    public void testRotateWithLargeShift() {
        assertEquals(8, SeventhTask.rotateRight(8, 100));
        assertEquals(16, SeventhTask.rotateLeft(16, 100));
    }
}


