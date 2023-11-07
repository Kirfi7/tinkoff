package edu.hw5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task7Test {

    @Test
    void checkRegexPattern1ValidInput() {
        String input = "101010";
        assertFalse(input.matches(Task7.REGULAR_1));
    }

    @Test
    void checkRegexPattern1InvalidInput() {
        String input = "001";
        assertFalse(input.matches(Task7.REGULAR_1));
    }

    @Test
    void checkRegexPattern2ValidInput() {
        String input = "010";
        assertTrue(input.matches(Task7.REGULAR_2));
    }

    @Test
    void checkRegexPattern2InvalidInput() {
        String input = "101";
        assertTrue(input.matches(Task7.REGULAR_2));
    }

    @Test
    void checkRegexPattern3ValidInput() {
        String input = "110";
        assertTrue(input.matches(Task7.REGULAR_3));
    }

    @Test
    void checkRegexPattern3InvalidInput() {
        String input = "1111";
        assertFalse(input.matches(Task7.REGULAR_3));
    }
}

