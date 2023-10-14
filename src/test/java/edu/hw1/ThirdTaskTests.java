package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ThirdTaskTests {
    @Test
    public void testIsNestableWithValidInput() {
        assertTrue(ThirdTask.isNestable(new int[]{1, 2, 3, 4}, new int[]{0, 6}));
        assertTrue(ThirdTask.isNestable(new int[]{3, 1}, new int[]{4, 0}));
        assertFalse(ThirdTask.isNestable(new int[]{9, 9, 8}, new int[]{8, 9}));
        assertFalse(ThirdTask.isNestable(new int[]{1, 2, 3, 4}, new int[]{2, 3}));
    }

    @Test
    public void testIsNestableWithEmptyArray() {
        assertFalse(ThirdTask.isNestable(new int[]{}, new int[]{1, 2}));
        assertFalse(ThirdTask.isNestable(new int[]{1, 2, 3}, new int[]{}));
        assertFalse(ThirdTask.isNestable(new int[]{}, new int[]{}));
    }

    @Test
    public void testIsNestableWithEqualMinMax() {
        assertFalse(ThirdTask.isNestable(new int[]{1, 2, 3}, new int[]{1, 2, 3}));
    }
}
