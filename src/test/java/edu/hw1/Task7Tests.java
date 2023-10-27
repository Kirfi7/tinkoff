package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task7Tests {

    @Test
    public void testRotateRight() {
        assertEquals(4, Task7.rotateRight(8, 1));
        assertEquals(8, Task7.rotateRight(16, 6));
        assertEquals(12, Task7.rotateRight(17, 2));
    }

    @Test
    public void testRotateLeft() {
        assertEquals(4, Task7.rotateLeft(8, 31));
        assertEquals(1, Task7.rotateLeft(16, 6));
        assertEquals(6, Task7.rotateLeft(17, 2));
    }

    @Test
    public void testRotateWithZeroShift() {
        assertEquals(8, Task7.rotateRight(8, 0));
        assertEquals(16, Task7.rotateLeft(16, 0));
        assertEquals(17, Task7.rotateLeft(17, 0));
    }

    @Test
    public void testRotateWithLargeShift() {
        assertEquals(8, Task7.rotateRight(8, 100));
        assertEquals(16, Task7.rotateLeft(16, 100));
    }
}


