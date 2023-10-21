package edu.project1;

import java.util.Random;
import java.util.Scanner;

@SuppressWarnings("RegexpSinglelineJava")
public class Task1 {

    private Task1() {
    }

    private static String[] words = {"hello", "world", "java", "programming", "computer"};
    private static String[] originalWords;
    private static final int MAX_MISTAKES = 5;
    private static final int ALPHABET_SIZE = 26;
    private static final String GUESS_PROMPT = "Guess a letter:";
    private static final String ALREADY_GUESSED_MESSAGE = "You've already guessed this letter. Try another one.";
    private static final String MULTI_CHARACTER_MESSAGE = "You've entered more than one character. Try again.";
    private static final String WON_MESSAGE = "You won!";
    private static final String THE_WORD_MESSAGE = "The word: ";

    private static String getConsoleInput(Scanner scanner, String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    public static void setWords(String[] testWords) {
        originalWords = words.clone();
        words = testWords;
    }

    public static void restoreOriginalWords() {
        words = originalWords.clone();
    }

    public static void run(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String wordToGuess = words[random.nextInt(words.length)];
        char[] wordState = new char[wordToGuess.length()];
        for (int i = 0; i < wordState.length; i++) {
            wordState[i] = '*';
        }
        int mistakes = 0;
        boolean[] guessedLetters = new boolean[ALPHABET_SIZE];
        while (mistakes < MAX_MISTAKES) {
            String input = getConsoleInput(scanner, GUESS_PROMPT);
            if (input.length() != 1) {
                System.out.println(MULTI_CHARACTER_MESSAGE);
                continue;
            }
            char guess = input.toLowerCase().charAt(0);
            if (guess - 'a' < 0 || guess - 'a' >= ALPHABET_SIZE) {
                System.out.println("Invalid input. Enter a valid character.");
                continue;
            }
            if (guessedLetters[guess - 'a']) {
                System.out.println(ALREADY_GUESSED_MESSAGE);
                continue;
            }
            guessedLetters[guess - 'a'] = true;
            if (wordToGuess.indexOf(guess) != -1) {
                for (int i = 0; i < wordToGuess.length(); i++) {
                    if (wordToGuess.charAt(i) == guess) {
                        wordState[i] = guess;
                    }
                }
                if (String.valueOf(wordState).equals(wordToGuess)) {
                    System.out.println(WON_MESSAGE);
                    break;
                }
            } else {
                mistakes++;
                System.out.println("Missed, mistake " + mistakes + " out of " + MAX_MISTAKES + ".");
                if (mistakes == MAX_MISTAKES) {
                    System.out.println(THE_WORD_MESSAGE + wordToGuess);
                    System.out.println("You lost!");
                    break;
                }
            }

            System.out.println(THE_WORD_MESSAGE + String.valueOf(wordState));
        }
        scanner.close();
    }
}
