package edu.hw3;

import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task7Tests {

    @Test
    void testTreeMapWithNullComparatorContainsNull() {
        // Создаем TreeMap с компаратором, который позволяет обрабатывать null
        TreeMap<String, String> tree = new TreeMap<>(new Task7.NullComparator());
        tree.put(null, "test");

        // Проверяем, содержит ли TreeMap null
        assertTrue(tree.containsKey(null));
    }

    @Test
    void testTreeMapWithNullComparatorNotContainsNull() {
        // Создаем TreeMap с компаратором, который позволяет обрабатывать null
        TreeMap<String, String> tree = new TreeMap<>(new Task7.NullComparator());
        tree.put("key", "test");

        // Проверяем, не содержит ли TreeMap null
        assertFalse(tree.containsKey(null));
    }

    @Test
    void testTreeMapWithNullComparatorSize() {
        // Создаем TreeMap с компаратором, который позволяет обрабатывать null
        TreeMap<String, String> tree = new TreeMap<>(new Task7.NullComparator());
        tree.put(null, "test");
        tree.put("key", "value");

        // Проверяем размер TreeMap
        assertTrue(tree.size() == 2);
    }

    @Test
    void testTreeMapWithNullComparatorNullValue() {
        // Создаем TreeMap с компаратором, который позволяет обрабатывать null
        TreeMap<String, String> tree = new TreeMap<>(new Task7.NullComparator());
        tree.put(null, null);

        // Проверяем, содержит ли TreeMap null как значение
        assertTrue(tree.containsValue(null));
    }
}

