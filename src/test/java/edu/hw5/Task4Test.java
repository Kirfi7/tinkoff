package edu.hw5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task4Test {

    @Test
    void checkPasswordCorrectnessWithSpecialCharacters() {
        String password = "Password!123";
        assertTrue(Task4.checkPasswordCorrectness(password));
    }

    @Test
    void checkPasswordCorrectnessWithoutSpecialCharacters() {
        String password = "Password123";
        assertFalse(Task4.checkPasswordCorrectness(password));
    }

    @Test
    void checkPasswordCorrectnessWithOnlySpecialCharacters() {
        String password = "!@#";
        assertTrue(Task4.checkPasswordCorrectness(password));
    }
}

