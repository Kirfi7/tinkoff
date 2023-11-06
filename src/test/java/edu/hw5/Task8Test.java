package edu.hw5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task8Test {

    @Test
    void checkRegexPattern1ValidInput() {
        String input = "1010";
        assertFalse(input.matches(Task8.REGULAR_1));
    }

    @Test
    void checkRegexPattern1InvalidInput() {
        String input = "10102";
        assertFalse(input.matches(Task8.REGULAR_1));
    }

    @Test
    void checkRegexPattern2ValidInput() {
        String input = "0110";
        assertTrue(input.matches(Task8.REGULAR_2));
    }

    @Test
    void checkRegexPattern2InvalidInput() {
        String input = "1101";
        assertFalse(input.matches(Task8.REGULAR_2));
    }

    @Test
    void checkRegexPattern3ValidInput() {
        String input = "1010101";
        assertTrue(input.matches(Task8.REGULAR_3));
    }

    @Test
    void checkRegexPattern3InvalidInput() {
        String input = "1001001";
        assertFalse(input.matches(Task8.REGULAR_3));
    }

    @Test
    void checkRegexPattern4ValidInput() {
        String input = "010101";
        assertTrue(input.matches(Task8.REGULAR_4));
    }

    @Test
    void checkRegexPattern4InvalidInput() {
        String input = "111";
        assertFalse(input.matches(Task8.REGULAR_4));
    }

    @Test
    void checkRegexPattern5ValidInput() {
        String input = "10101";
        assertTrue(input.matches(Task8.REGULAR_5));
    }

    @Test
    void checkRegexPattern5InvalidInput() {
        String input = "1002";
        assertFalse(input.matches(Task8.REGULAR_5));
    }

    @Test
    void checkRegexPattern6ValidInput() {
        String input = "001";
        assertTrue(input.matches(Task8.REGULAR_6));
    }

    @Test
    void checkRegexPattern6InvalidInput() {
        String input = "1001";
        assertFalse(input.matches(Task8.REGULAR_6));
    }

    @Test
    void checkRegexPattern7ValidInput() {
        String input = "01010";
        assertTrue(input.matches(Task8.REGULAR_7));
    }

    @Test
    void checkRegexPattern7InvalidInput() {
        String input = "011";
        assertFalse(input.matches(Task8.REGULAR_7));
    }
}
