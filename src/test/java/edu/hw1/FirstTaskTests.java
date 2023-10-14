package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FirstTaskTests {
    @Test
    public void testValidInput() {
        assertEquals(60, FirstTask.minutesToSeconds("01:00"));
        assertEquals(836, FirstTask.minutesToSeconds("13:56"));
    }

    @Test
    public void testInvalidInput() {
        assertEquals(-1, FirstTask.minutesToSeconds("10:60"));
        assertEquals(-1, FirstTask.minutesToSeconds("abc:def"));
        assertEquals(-1, FirstTask.minutesToSeconds("12"));
        assertEquals(-1, FirstTask.minutesToSeconds("12:"));
        assertEquals(-1, FirstTask.minutesToSeconds(":34"));
        assertEquals(-1, FirstTask.minutesToSeconds(""));
    }
}
