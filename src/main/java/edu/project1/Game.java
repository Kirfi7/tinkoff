package edu.project1;

import java.util.Arrays;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Game {
    private static final String EXIT_PHRASE = "to exit";
    private static final int MIN_WORD_LEN = 3;
    private final String word;
    private final char[] userSequence;
    private final int maxMistakesAllowed;
    private int mistakeCount = 0;
    private final Logger logger = LogManager.getLogger();

    public Game(int maxMistakesAllowed) {
        if (maxMistakesAllowed <= 0) {
            throw new IllegalArgumentException();
        }

        this.maxMistakesAllowed = maxMistakesAllowed;
        word = Dictionary.getWord().toLowerCase();
        int wordLen = word.length();

        if (wordLen < MIN_WORD_LEN) {
            throw new IllegalWordException(word);
        }

        userSequence = new char[wordLen];
        Arrays.fill(userSequence, '*');
    }

    public void play() {
        Scanner inputReader = new Scanner(System.in);

        while (true) {
            String input = getInputOrNull(inputReader);

            if (input == null || input.equalsIgnoreCase(EXIT_PHRASE)) {
                break;
            }

            if (input.length() != 1) {
                continue;
            }

            char charInput = input.charAt(0);
            SessionResult result = ResultUtils.getIntermediateResult(
                word, userSequence, charInput, maxMistakesAllowed, mistakeCount
            );

            if (result instanceof SessionResult.FailedGuess) {
                mistakeCount++;
            } else {
                HiddenWordUtils.openLettersInSequence(userSequence, word, charInput);
            }

            logger.info(result.message());
            logger.info("");
        }
    }

    private String getInputOrNull(Scanner inputReader) {
        logger.info("The word: " + new String(userSequence));
        logger.info("");

        SessionResult result = ResultUtils.getFinalResultOrNull(word, userSequence, maxMistakesAllowed, mistakeCount);

        if (result != null) {
            logger.info(result.message());
            return null;
        }

        logger.info("Guess a letter:");

        return inputReader.nextLine().toLowerCase();
    }
}
