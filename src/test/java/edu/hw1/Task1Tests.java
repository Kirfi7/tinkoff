package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task1Tests {
    @Test
    public void testValidInput() {
        assertEquals(60, Task1.minutesToSeconds("01:00"));
        assertEquals(836, Task1.minutesToSeconds("13:56"));
    }

    @Test
    public void testInvalidInput() {
        assertEquals(-1, Task1.minutesToSeconds("10:60"));
        assertEquals(-1, Task1.minutesToSeconds("abc:def"));
        assertEquals(-1, Task1.minutesToSeconds("12"));
        assertEquals(-1, Task1.minutesToSeconds("12:"));
        assertEquals(-1, Task1.minutesToSeconds(":34"));
        assertEquals(-1, Task1.minutesToSeconds(""));
    }
}
