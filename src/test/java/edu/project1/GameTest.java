package edu.project1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    private Game game;
    private InputStream stdin;

    @BeforeEach
    public void init() {
        this.game = new Game(5);
        this.stdin = System.in;
    }

    @Test
    public void testGetInputOrNull() {
        String testString = "testInput";
        System.setIn(new ByteArrayInputStream(testString.getBytes()));
        Scanner scanner = new Scanner(System.in);
        String result = game.getInputOrNull(scanner);
        assertEquals(testString.toLowerCase(), result);
        System.setIn(stdin);
    }
}
