package edu.hw3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3Tests {

    @Test
    void testFreqDict1() {
        List<Object> list = Arrays.asList("a", "bb", "a", "bb");
        Map<Object, Integer> result = Task3.freqDict(list);
        assertEquals(2, result.get("a"));
        assertEquals(2, result.get("bb"));
    }

    @Test
    void testFreqDict2() {
        List<Object> list = Arrays.asList("this", "and", "that", "and");
        Map<Object, Integer> result = Task3.freqDict(list);
        assertEquals(1, result.get("this"));
        assertEquals(2, result.get("and"));
        assertEquals(1, result.get("that"));
    }

    @Test
    void testFreqDict3() {
        List<Object> list = Arrays.asList("код", "код", "код", "bug");
        Map<Object, Integer> result = Task3.freqDict(list);
        assertEquals(3, result.get("код"));
        assertEquals(1, result.get("bug"));
    }

    @Test
    void testFreqDict4() {
        List<Object> list = Arrays.asList(1, 1, 2, 2);
        Map<Object, Integer> result = Task3.freqDict(list);
        assertEquals(2, result.get(1));
        assertEquals(2, result.get(2));
    }

    @Test
    void testFreqDictWithEmptyList() {
        List<Object> list = Arrays.asList();
        Map<Object, Integer> result = Task3.freqDict(list);
        assertEquals(0, result.size());
    }

    @Test
    void testFreqDictWithSingleElement() {
        List<Object> list = Arrays.asList("a");
        Map<Object, Integer> result = Task3.freqDict(list);
        assertEquals(1, result.get("a"));
    }

    @Test
    void testFreqDictWithMultipleTypes() {
        List<Object> list = Arrays.asList(1, "a", 2, "a", "b", 2, 1, 1);
        Map<Object, Integer> result = Task3.freqDict(list);
        assertEquals(3, result.get(1));
        assertEquals(2, result.get("a"));
        assertEquals(2, result.get(2));
        assertEquals(1, result.get("b"));
    }
}

