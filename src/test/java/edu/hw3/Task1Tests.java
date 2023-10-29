package edu.hw3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Tests {

    @Test
    public void testAtbashWithHelloWorld() {
        String input = "Hello world!";
        String expectedOutput = "Svool dliow!";
        assertEquals(expectedOutput, Task1.atbash(input));
    }

    @Test
    public void testAtbashWithLongString() {
        String input = "Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler";
        String expectedOutput = "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi";
        assertEquals(expectedOutput, Task1.atbash(input));
    }

    @Test
    public void testAtbashWithAlphabet() {
        String input = "abcdefghijklmnopqrstuvwxyz";
        String expectedOutput = "zyxwvutsrqponmlkjihgfedcba";
        assertEquals(expectedOutput, Task1.atbash(input));
    }

    @Test
    public void testAtbashWithUpperCase() {
        String input = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String expectedOutput = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
        assertEquals(expectedOutput, Task1.atbash(input));
    }

    @Test
    public void testAtbashWithNonAlphabeticCharacters() {
        String input = "123!@#$";
        String expectedOutput = "123!@#$";
        assertEquals(expectedOutput, Task1.atbash(input));
    }
}

