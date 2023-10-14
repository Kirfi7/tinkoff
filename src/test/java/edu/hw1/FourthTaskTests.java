package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FourthTaskTests {
    @Test
    public void testFixStringWithEvenLength() {
        assertEquals("214365", FourthTask.fixString("123456"));
        assertEquals("This is a mixed up string.", FourthTask.fixString("hTsii  s aimex dpus rtni.g"));
    }

    @Test
    public void testFixStringWithOddLength() {
        assertEquals("Invalid Input", FourthTask.fixString("12345"));
        assertEquals("Invalid Input", FourthTask.fixString("abcde"));
        assertEquals("Invalid Input", FourthTask.fixString("badce"));
    }

    @Test
    public void testFixStringWithNullInput() {
        assertEquals("Invalid Input", FourthTask.fixString(null));
    }
}

