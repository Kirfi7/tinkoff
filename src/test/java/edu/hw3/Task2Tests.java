package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class Task2Tests {

    @Test
    void testClusterize1() {
        String input = "()()()";
        List<String> expected = List.of("()", "()", "()");
        assertEquals(expected, Task2.clusterize(input));
    }

    @Test
    void testClusterize2() {
        String input = "((()))";
        List<String> expected = List.of("((()))");
        assertEquals(expected, Task2.clusterize(input));
    }

    @Test
    void testClusterize3() {
        String input = "((()))(())()()(()())";
        List<String> expected = List.of("((()))", "(())", "()", "()", "(()())");
        assertEquals(expected, Task2.clusterize(input));
    }

    @Test
    void testClusterize4() {
        String input = "((())())(()(()()))";
        List<String> expected = List.of("((())())", "(()(()()))");
        assertEquals(expected, Task2.clusterize(input));
    }

    @Test
    void testInvalidInput() {
        String input = "((())()(()(()()))";
        assertThrows(IllegalArgumentException.class, () -> Task2.clusterize(input));
    }

    @Test
    void testInvalidInputWithUnbalancedBrackets() {
        String input = "((())()(()(()()))";
        assertThrows(IllegalArgumentException.class, () -> Task2.clusterize(input));
    }
}
