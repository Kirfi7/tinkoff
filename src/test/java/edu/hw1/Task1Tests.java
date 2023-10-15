package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task1Tests {
    @Test
    public void testValidInput() {
        assertEquals(60, Task1.minutesToSeconds("01:00"));
        assertEquals(836, Task1.minutesToSeconds("13:56"));
        assertEquals(0, Task1.minutesToSeconds("00:00"));
        assertEquals(180, Task1.minutesToSeconds("03:00"));
        assertEquals(122, Task1.minutesToSeconds("02:02"));
        assertEquals(366, Task1.minutesToSeconds("06:06"));
        assertEquals(1800, Task1.minutesToSeconds("30:00"));
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
