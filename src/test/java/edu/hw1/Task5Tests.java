package edu.hw1;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Task5Tests {
    @Test
    public void testIsPalindromeDescendantWithPalindromeNumber() {
        assertTrue(Task5.isPalindromeDescendant(11));
        assertTrue(Task5.isPalindromeDescendant(121));
        assertTrue(Task5.isPalindromeDescendant(12321));
    }

    @Test
    public void testIsPalindromeDescendantWithNonPalindromeNumber() {
        assertTrue(Task5.isPalindromeDescendant(11211230));
        assertTrue(Task5.isPalindromeDescendant(13001120));
        assertTrue(Task5.isPalindromeDescendant(23336014));
    }

    @Test
    public void testIsPalindromeDescendantWithSingleDigit() {
        assertFalse(Task5.isPalindromeDescendant(5));
    }

    @Test
    public void testIsPalindromeDescendantWithNullInput() {
        assertFalse(Task5.isPalindromeDescendant(0));
    }
}

