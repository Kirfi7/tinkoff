package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task3Tests {
    @Test
    public void testIsNestableWithValidInput() {
        assertTrue(Task3.isNestable(new int[]{1, 2, 3, 4}, new int[]{0, 6}));
        assertTrue(Task3.isNestable(new int[]{3, 1}, new int[]{4, 0}));
        assertFalse(Task3.isNestable(new int[]{9, 9, 8}, new int[]{8, 9}));
        assertFalse(Task3.isNestable(new int[]{1, 2, 3, 4}, new int[]{2, 3}));
    }

    @Test
    public void testIsNestableWithEmptyArray() {
        assertFalse(Task3.isNestable(new int[]{}, new int[]{1, 2}));
        assertFalse(Task3.isNestable(new int[]{1, 2, 3}, new int[]{}));
        assertFalse(Task3.isNestable(new int[]{}, new int[]{}));
    }

    @Test
    public void testIsNestableWithEqualMinMax() {
        assertFalse(Task3.isNestable(new int[]{1, 2, 3}, new int[]{1, 2, 3}));
    }

    @Test
    public void testIsNestableWithValidInputDescending() {
        assertTrue(Task3.isNestable(new int[]{5, 4, 3, 2, 1}, new int[]{6, 0}));
    }

    @Test
    public void testIsNestableWithSingleElementArrays() {
        assertFalse(Task3.isNestable(new int[]{5}, new int[]{5}));
        assertTrue(Task3.isNestable(new int[]{2}, new int[]{1, 3}));
    }

    @Test
    public void testIsNestableWithLargeArrays() {
        assertTrue(Task3.isNestable(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, new int[]{0, 11}));
        assertFalse(Task3.isNestable(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, new int[]{0, 10}));
    }
}
