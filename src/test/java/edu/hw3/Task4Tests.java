package edu.hw3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task4Tests {

    @Test
    public void testConvertToRoman() {
        assertEquals("II", Task4.convertToRoman(2));
        assertEquals("XII", Task4.convertToRoman(12));
        assertEquals("XVI", Task4.convertToRoman(16));
        assertEquals("M", Task4.convertToRoman(1000));
        assertEquals("CM", Task4.convertToRoman(900));
        assertEquals("MCMXCIX", Task4.convertToRoman(1999));
        assertEquals("MMMCMXCIX", Task4.convertToRoman(3999));
    }

    @Test
    public void testOutOfRange() {
        assertThrows(IllegalArgumentException.class, () -> Task4.convertToRoman(0));
        assertThrows(IllegalArgumentException.class, () -> Task4.convertToRoman(4000));
    }

    @Test
    public void testRandomNumbers() {
        assertEquals("XLIX", Task4.convertToRoman(49));
        assertEquals("DCCXLV", Task4.convertToRoman(745));
        assertEquals("CDXC", Task4.convertToRoman(490));
        assertEquals("XXX", Task4.convertToRoman(30));
    }

    @Test
    public void testExtremeCases() {
        assertEquals("I", Task4.convertToRoman(1));
        assertEquals("IV", Task4.convertToRoman(4));
        assertEquals("V", Task4.convertToRoman(5));
        assertEquals("IX", Task4.convertToRoman(9));
    }
}

