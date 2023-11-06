package edu.hw5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task6Test {

    @Test
    void isSubsequenceValidSubsequence() {
        String sequence = "abcdefg";
        String subsequence = "aceg";
        assertFalse(Task6.isSubsequence(sequence, subsequence));
    }

    @Test
    void isSubsequenceInvalidSubsequence() {
        String sequence = "abcdefg";
        String subsequence = "aecg";
        assertFalse(Task6.isSubsequence(sequence, subsequence));
    }

    @Test
    void isSubsequenceEmptySubsequence() {
        String sequence = "abcdefg";
        String subsequence = "";
        assertTrue(Task6.isSubsequence(sequence, subsequence));
    }
}

