package edu.project1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SessionTest {

    @Test
    public void testDefeatMessage() {
        SessionResult.Defeat defeat = new SessionResult.Defeat();
        assertEquals("You lost!", defeat.message());
    }

    @Test
    public void testWinMessage() {
        SessionResult.Win win = new SessionResult.Win();
        assertEquals("You won!", win.message());
    }

    @Test
    public void testSuccessfulGuessMessage() {
        SessionResult.SuccessfulGuess successfulGuess = new SessionResult.SuccessfulGuess();
        assertEquals("Hit!", successfulGuess.message());
    }

    @Test
    public void testFailedGuessMessage() {
        int maxMistakesAllowed = 5;
        int mistakeCount = 2;
        SessionResult.FailedGuess failedGuess = new SessionResult.FailedGuess(maxMistakesAllowed, mistakeCount);
        assertEquals("Missed, mistake 3 out of 5.", failedGuess.message());
    }
}

