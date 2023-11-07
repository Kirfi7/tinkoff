package edu.project1;

import java.util.Arrays;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("checkstyle:MagicNumber")
public class Game {
    public static final String EXIT_PHRASE = "to exit";
    private static final int MIN_WORD_LEN = 3;
    private final String word;
    private final char[] userSequence;
    private final int maxMistakesAllowed;
    private int mistakeCount = 0;
    private final Logger logger = LogManager.getLogger();

    public Game(int maxMistakesAllowed) {
        // Проверка на валидность значения maxMistakesAllowed
        if (maxMistakesAllowed <= 0) {
            throw new IllegalArgumentException();
        }

        this.maxMistakesAllowed = maxMistakesAllowed;
        word = Dictionary.getWord().toLowerCase();
        int wordLen = word.length();

        // Проверка на минимальную длину слова
        if (wordLen < MIN_WORD_LEN) {
            throw new IllegalWordException(word);
        }

        userSequence = new char[wordLen];
        Arrays.fill(userSequence, '*');
    }

    // Метод play представляет игровой процесс
    public void play() {
        Scanner inputReader = new Scanner(System.in);

        while (true) {
            // Получение ввода от пользователя
            String input = getInputOrNull(inputReader);

            // Проверка на выход из игры
            if (input == null || input.equalsIgnoreCase(EXIT_PHRASE)) {
                break;
            }

            // Проверка на длину ввода
            if (input.length() != 1) {
                continue;
            }

            // Обработка введенного символа
            char charInput = input.charAt(0);
            SessionResult result = ResultUtils.getIntermediateResult(
                word, userSequence, charInput, maxMistakesAllowed, mistakeCount
            );

            // Обновление счетчика ошибок или последовательности символов
            if (result instanceof SessionResult.FailedGuess) {
                mistakeCount++;
                printHangman();
            } else {
                HiddenWordUtils.openLettersInSequence(userSequence, word, charInput);
            }

            // Вывод результата и текущей последовательности
            logger.info(result.message());
            logger.info("");
        }
    }

    // Метод getInputOrNull возвращает ввод пользователя или null, если игра закончена
    String getInputOrNull(Scanner inputReader) {
        logger.info("The word: " + new String(userSequence));
        logger.info("");

        SessionResult result = ResultUtils.getFinalResultOrNull(word, userSequence, maxMistakesAllowed, mistakeCount);

        // Проверка на окончание игры
        if (result != null) {
            logger.info(result.message());
            return null;
        }

        // Получение ввода пользователя
        logger.info("Guess a letter:");

        return inputReader.nextLine().toLowerCase();
    }

    @SuppressWarnings("checkstyle:MultipleStringLiterals")
    private void printHangman() {
        int remainingChances = maxMistakesAllowed - mistakeCount;
        logger.info("Remaining chances: " + remainingChances);

        // Вывод палочек в зависимости от количества ошибок
        switch (mistakeCount) {
            case 0:
                logger.info("|----- |");
                logger.info("|      |");
                logger.info("|      |");
                logger.info("|      |");
                logger.info("|      |");
                logger.info("|______|");
                break;
            case 1:
                logger.info("|----- |");
                logger.info("|     O|");
                logger.info("|      |");
                logger.info("|      |");
                logger.info("|      |");
                logger.info("|______|");
                break;
            case 2:
                logger.info("|----- |");
                logger.info("|     O|");
                logger.info("|     |");
                logger.info("|      |");
                logger.info("|      |");
                logger.info("|______|");
                break;
            case 3:
                logger.info("|----- |");
                logger.info("|     O|");
                logger.info("|    /|");
                logger.info("|      |");
                logger.info("|      |");
                logger.info("|______|");
                break;
            case 4:
                logger.info("|----- |");
                logger.info("|     O|");
                logger.info("|    /|\\");
                logger.info("|      |");
                logger.info("|      |");
                logger.info("|______|");
                break;
            case 5:
                logger.info("|----- |");
                logger.info("|     O|");
                logger.info("|    /|\\");
                logger.info("|    / |");
                logger.info("|      |");
                logger.info("|______|");
                break;
            case 6:
                logger.info("|----- |");
                logger.info("|     O|");
                logger.info("|    /|\\");
                logger.info("|    / \\");
                logger.info("|      |");
                logger.info("|______|");
                break;
            default:
                break;
        }
    }
}

