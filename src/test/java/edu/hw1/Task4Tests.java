package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task4Tests {
    @Test
    public void testFixStringWithEvenLength() {
        assertEquals("214365", Task4.fixString("123456"));
        assertEquals("This is a mixed up string.", Task4.fixString("hTsii  s aimex dpus rtni.g"));
    }

    @Test
    public void testFixStringWithOddLength() {
        assertEquals("Invalid Input", Task4.fixString("12345"));
        assertEquals("Invalid Input", Task4.fixString("abcde"));
        assertEquals("Invalid Input", Task4.fixString("badce"));
    }

    @Test
    public void testFixStringWithNullInput() {
        assertEquals("Invalid Input", Task4.fixString(null));
    }

    @Test
    public void testFixStringWithEmptyString() {
        assertEquals("", Task4.fixString(""));
    }
}

