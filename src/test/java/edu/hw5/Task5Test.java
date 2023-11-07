package edu.hw5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task5Test {

    @Test
    void checkPatternMatchValidInput() {
        String input = "А123БВ456";
        assertTrue(input.matches(Task5.PATTERN));
    }

    @Test
    void checkPatternMatchInvalidInput() {
        String input = "123ABC456";
        assertFalse(input.matches(Task5.PATTERN));
    }
}

