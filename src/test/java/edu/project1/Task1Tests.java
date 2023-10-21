package edu.project1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task1Tests {

    private final InputStream sysInBackup = System.in;
    private final PrintStream sysOutBackup = System.out;

    private ByteArrayInputStream in;
    private ByteArrayOutputStream out;

    private static final Logger LOGGER = Logger.getLogger(Task1.class.getName());

    @BeforeEach
    public void setUpStreams() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        LOGGER.setUseParentHandlers(false);
        LOGGER.setLevel(java.util.logging.Level.OFF);
    }

    @AfterEach
    public void restoreStreams() {
        System.setIn(sysInBackup);
        System.setOut(sysOutBackup);
    }

    @Test
    public void testWinScenario() {
        String inputString = "h\ne\nl\nl\no\n";
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        String[] testWords = {"hello"};
        Task1.setWords(testWords);

        try {
            Task1.run(new String[]{});
            assertTrue(out.toString().contains("You won!"));
        } finally {
            System.setIn(sysInBackup);
            System.setOut(System.out);
            Task1.restoreOriginalWords();
        }
    }

    @Test
    public void testMaxMistakesReturnLoss() {
        String[] testWords = {"hello"};
        Task1.setWords(testWords);

        String inputString = "a\nb\nc\nd\ne\n";
        in = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(in);

        try {
            Task1.run(new String[]{});
            assertTrue(out.toString().contains("You lost!"), "After exceeding the maximum number of mistakes, the game should always return loss");
        } catch (NoSuchElementException e) {
            System.setIn(sysInBackup);
        } finally {
            System.setOut(System.out);
            Task1.restoreOriginalWords();
        }
    }

    @Test
    public void testGameplayStateChange() {
        String[] testWords = {"hello"};
        Task1.setWords(testWords);

        String inputString = "h\n" +
            "e\n" +
            "p\n";
        ByteArrayInputStream in = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(out));

        InputStream sysInBackup = System.in;
        PrintStream sysOutBackup = System.out;

        try {
            Task1.run(null);
            String output = out.toString();
            assertTrue(output.contains("The word: h****"), "Game state should change after a correct guess");
            assertTrue(output.contains("The word: he**"), "Game state should change after a correct guess");
            assertTrue(output.contains("Missed, mistake 1 out of 5."), "Game state should change after a wrong guess");
            assertTrue(output.contains("You won!"), "Game should return win after the word is guessed correctly");
        } catch (NoSuchElementException e) {
            System.setIn(sysInBackup);
        } finally {
            System.setOut(originalOut);
            Task1.restoreOriginalWords();
        }
    }


    @Test
    public void testMultiCharacterInput() {
        String[] testWords = {"hello"};
        Task1.setWords(testWords);

        String inputString = "ab\nh\n";
        ByteArrayInputStream in = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        try {
            Task1.run(new String[]{});
            assertFalse(out.toString().contains("The word: ab***"), "Game state should not change after multi-character input");
            assertTrue(out.toString().contains("You've entered more than one character. Try again."), "Game should prompt for another input when more than one character is entered");
        } catch (NoSuchElementException e) {
            System.setIn(sysInBackup);
        } finally {
            System.setOut(sysOutBackup);
            Task1.restoreOriginalWords();
        }
    }

    @Test
    public void testMaxMistakesReturnLoss2() {
        String[] testWords = {"hello"};
        Task1.setWords(testWords);

        String inputString = "a\nb\nc\nd\ne\n";
        ByteArrayInputStream in = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        try {
            Task1.run(new String[]{});
            assertTrue(out.toString().contains("You lost!"), "After exceeding the maximum number of mistakes, the game should always return loss");
        } catch (NoSuchElementException e) {
            System.setIn(sysInBackup);
        } finally {
            System.setOut(sysOutBackup);
            Task1.restoreOriginalWords();
        }
    }

    @Test
    public void testWinScenarioWorld() {
        String inputString = "w\no\nr\nl\nd\n";
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        String[] testWords = {"world"};
        Task1.setWords(testWords);

        try {
            Task1.run(new String[]{});
            assertTrue(out.toString().contains("You won!"));
        } finally {
            System.setIn(sysInBackup);
            System.setOut(System.out);
            Task1.restoreOriginalWords();
        }
    }

    @Test
    public void testWinScenarioJava() {
        String inputString = "j\na\nv\na\n";
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        String[] testWords = {"java"};
        Task1.setWords(testWords);

        try {
            Task1.run(new String[]{});
            assertTrue(out.toString().contains("You won!"));
        } finally {
            System.setIn(sysInBackup);
            System.setOut(System.out);
            Task1.restoreOriginalWords();
        }
    }

    @Test
    public void testWinScenarioProgramming() {
        String inputString = "p\nr\no\ng\nr\na\nm\nm\ni\nn\ng\n";
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        String[] testWords = {"programming"};
        Task1.setWords(testWords);

        try {
            Task1.run(new String[]{});
            assertTrue(out.toString().contains("You won!"));
        } finally {
            System.setIn(sysInBackup);
            System.setOut(System.out);
            Task1.restoreOriginalWords();
        }
    }

    @Test
    public void testMaxMistakesReturnLossComputer() {
        String[] testWords = {"computer"};
        Task1.setWords(testWords);

        String inputString = "a\nb\nc\nd\ne\n";
        ByteArrayInputStream in = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        try {
            Task1.run(new String[]{});
            assertTrue(out.toString().contains("You lost!"), "After exceeding the maximum number of mistakes, the game should always return loss");
        } catch (NoSuchElementException e) {
            System.setIn(sysInBackup);
        } finally {
            System.setOut(sysOutBackup);
            Task1.restoreOriginalWords();
        }
    }

    @Test
    public void testMultiCharacterInputComputer() {
        String[] testWords = {"computer"};
        Task1.setWords(testWords);

        String inputString = "com\np\nu\nt\ne\nr\n";
        ByteArrayInputStream in = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        try {
            Task1.run(new String[]{});
            assertFalse(out.toString().contains("The word: com*****"), "Game state should not change after multi-character input");
            assertTrue(out.toString().contains("You've entered more than one character. Try again."), "Game should prompt for another input when more than one character is entered");
        } catch (NoSuchElementException e) {
            System.setIn(sysInBackup);
        } finally {
            System.setOut(sysOutBackup);
            Task1.restoreOriginalWords();
        }
    }
}
