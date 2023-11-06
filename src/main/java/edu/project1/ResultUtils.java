package edu.project1;

import edu.project1.SessionResult.Defeat;
import edu.project1.SessionResult.FailedGuess;
import edu.project1.SessionResult.SuccessfulGuess;
import edu.project1.SessionResult.Win;

// Утилиты для обработки результатов сеанса игры
public class ResultUtils {
    // Приватный конструктор класса
    private ResultUtils() {
    }

    // Получение промежуточного результата игры
    public static SessionResult getIntermediateResult(
        String word,
        char[] userSequence,
        char input,
        int maxMistakesAllowed,
        int mistakeCount
    ) {
        if (word.contains(Character.toString(input)) && !HiddenWordUtils.haveInCharArray(userSequence, input)) {
            return new SuccessfulGuess();
        }

        return new FailedGuess(maxMistakesAllowed, mistakeCount);
    }

    // Получение окончательного результата игры или нулевого значения
    public static SessionResult getFinalResultOrNull(
        String word,
        char[] userSequence,
        int maxMistakesAllowed,
        int mistakeCount
    ) {
        if (mistakeCount == maxMistakesAllowed) {
            return new Defeat();
        }

        for (var i = 0; i < userSequence.length; i++) {
            if (userSequence[i] != word.charAt(i)) {
                return null;
            }
        }

        return new Win();
    }
}
