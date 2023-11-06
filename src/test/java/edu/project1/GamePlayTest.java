package edu.project1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GamePlayTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private Game game;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        String input = "a\n" + Game.EXIT_PHRASE + "\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        game = new Game(5);
    }

    @Test
    public void testGetInputOrNull() {
        Game game = new Game(5);
        System.setIn(new ByteArrayInputStream("a\n".getBytes()));
        Scanner scanner = new Scanner(System.in);
        assertEquals("a", game.getInputOrNull(scanner));
    }

}
