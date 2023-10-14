package edu.hw1;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class FifthTaskTests {
    @Test
    public void testIsPalindromeDescendantWithPalindromeNumber() {
        assertTrue(FifthTask.isPalindromeDescendant(11));
        assertTrue(FifthTask.isPalindromeDescendant(121));
        assertTrue(FifthTask.isPalindromeDescendant(12321));
    }

    @Test
    public void testIsPalindromeDescendantWithNonPalindromeNumber() {
        assertTrue(FifthTask.isPalindromeDescendant(11211230));
        assertTrue(FifthTask.isPalindromeDescendant(13001120));
        assertTrue(FifthTask.isPalindromeDescendant(23336014));
    }

    @Test
    public void testIsPalindromeDescendantWithSingleDigit() {
        assertFalse(FifthTask.isPalindromeDescendant(5));
    }

    @Test
    public void testIsPalindromeDescendantWithNullInput() {
        assertFalse(FifthTask.isPalindromeDescendant(0));
    }
}

