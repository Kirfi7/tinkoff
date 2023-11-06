package edu.project1;

import java.util.Random;
import java.util.Scanner;

@SuppressWarnings("RegexpSinglelineJava")
public class Task1 {

    // Приватный конструктор для предотвращения создания экземпляров класса
    private Task1() {
    }

    // Слова для игры
    private static String[] words = {"hello", "world", "java", "programming", "computer"};
    private static String[] originalWords;

    // Максимальное количество ошибок и размер алфавита
    private static final int MAX_MISTAKES = 5;
    private static final int ALPHABET_SIZE = 26;

    // Сообщения для вывода
    private static final String GUESS_PROMPT = "Guess a letter:";
    private static final String ALREADY_GUESSED_MESSAGE = "You've already guessed this letter. Try another one.";
    private static final String MULTI_CHARACTER_MESSAGE = "You've entered more than one character. Try again.";
    private static final String WON_MESSAGE = "You won!";
    private static final String THE_WORD_MESSAGE = "The word: ";

    // Получение ввода от пользователя
    private static String getConsoleInput(Scanner scanner, String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    // Установка слов для тестирования
    public static void setWords(String[] testWords) {
        originalWords = words.clone();
        words = testWords;
    }

    // Восстановление исходных слов
    public static void restoreOriginalWords() {
        words = originalWords.clone();
    }

    // Метод запуска игры
    public static void run(String[] args) {
        // Создание объектов Scanner и Random
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Получение случайного слова для угадывания
        String wordToGuess = words[random.nextInt(words.length)];

        // Инициализация состояния слова
        char[] wordState = new char[wordToGuess.length()];
        for (int i = 0; i < wordState.length; i++) {
            wordState[i] = '*';
        }

        // Инициализация счетчика ошибок и массива для угаданных букв
        int mistakes = 0;
        boolean[] guessedLetters = new boolean[ALPHABET_SIZE];

        // Цикл игры
        while (mistakes < MAX_MISTAKES) {
            // Получение ввода от пользователя
            String input = getConsoleInput(scanner, GUESS_PROMPT);

            // Проверка на длину ввода
            if (input.length() != 1) {
                System.out.println(MULTI_CHARACTER_MESSAGE);
                continue;
            }

            // Получение угаданной буквы
            char guess = input.toLowerCase().charAt(0);

            // Проверка на корректность ввода
            if (guess - 'a' < 0 || guess - 'a' >= ALPHABET_SIZE) {
                System.out.println("Invalid input. Enter a valid character.");
                continue;
            }

            // Проверка на уже угаданную букву
            if (guessedLetters[guess - 'a']) {
                System.out.println(ALREADY_GUESSED_MESSAGE);
                continue;
            }

            // Обновление массива состояния слова
            if (wordToGuess.indexOf(guess) != -1) {
                for (int i = 0; i < wordToGuess.length(); i++) {
                    if (wordToGuess.charAt(i) == guess) {
                        wordState[i] = guess;
                    }
                }
                // Проверка на выигрыш
                if (String.valueOf(wordState).equals(wordToGuess)) {
                    System.out.println(WON_MESSAGE);
                    break;
                }
            } else {
                // Обновление счетчика ошибок и вывод сообщения о промахе
                mistakes++;
                System.out.println("Missed, mistake " + mistakes + " out of " + MAX_MISTAKES + ".");
                // Проверка на проигрыш
                if (mistakes == MAX_MISTAKES) {
                    System.out.println(THE_WORD_MESSAGE + wordToGuess);
                    System.out.println("You lost!");
                    break;
                }
            }

            // Вывод текущего состояния слова
            System.out.println(THE_WORD_MESSAGE + String.valueOf(wordState));
        }
        scanner.close();
    }
}

