package edu.project1;

public interface SessionResult {
    String message();

    record Defeat() implements SessionResult {
        @Override
        public String message() {
            return "You lost!";
        }
    }

    record Win() implements SessionResult {
        @Override
        public String message() {
            return "You won!";
        }
    }

    record SuccessfulGuess() implements SessionResult {
        @Override
        public String message() {
            return "Hit!";
        }
    }

    record FailedGuess(int maxMistakesAllowed, int mistakeCount) implements SessionResult {
        @Override
        public String message() {
            return String.format("Missed, mistake %d out of %d.", mistakeCount + 1, maxMistakesAllowed);
        }
    }

}
