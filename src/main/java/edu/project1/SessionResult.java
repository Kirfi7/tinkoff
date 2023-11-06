package edu.project1;

// Интерфейс для представления результатов сеанса игры
public interface SessionResult {
    // Сообщение, связанное с результатом
    String message();

    // Класс, представляющий поражение
    record Defeat() implements SessionResult {
        @Override
        public String message() {
            return "You lost!";
        }
    }

    // Класс, представляющий победу
    record Win() implements SessionResult {
        @Override
        public String message() {
            return "You won!";
        }
    }

    // Класс, представляющий удачное угадывание
    record SuccessfulGuess() implements SessionResult {
        @Override
        public String message() {
            return "Hit!";
        }
    }

    // Класс, представляющий неудачное угадывание
    record FailedGuess(int maxMistakesAllowed, int mistakeCount) implements SessionResult {
        @Override
        public String message() {
            return String.format("Missed, mistake %d out of %d.", mistakeCount + 1, maxMistakesAllowed);
        }
    }
}
