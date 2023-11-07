package edu.project1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IllegalWordExceptionTest {

    @Test
    void testIllegalWordExceptionMessage() {
        String word = "TestWord";
        try {
            throw new IllegalWordException(word);
        } catch (IllegalWordException e) {
            assertEquals(word + "can't be guessed", e.getMessage());
        }
    }
}

