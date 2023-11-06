package edu.hw3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Task8Tests {

    @Test
    void testBackwardIterator() {
        Task8.BackwardIterator<Integer> backwardIterator = new Task8.BackwardIterator<>(List.of(1, 2, 3));

        assertTrue(backwardIterator.hasNext());
        assertEquals(3, backwardIterator.next());

        assertTrue(backwardIterator.hasNext());
        assertEquals(2, backwardIterator.next());

        assertTrue(backwardIterator.hasNext());
        assertEquals(1, backwardIterator.next());

        assertFalse(backwardIterator.hasNext());
        assertNull(backwardIterator.next());
    }

    @Test
    void testEmptyBackwardIterator() {
        Task8.BackwardIterator<String> emptyBackwardIterator = new Task8.BackwardIterator<>(List.of());

        assertFalse(emptyBackwardIterator.hasNext());
        assertNull(emptyBackwardIterator.next());
    }

    @Test
    void testBackwardIteratorWithStrings() {
        Task8.BackwardIterator<String> stringBackwardIterator = new Task8.BackwardIterator<>(List.of("apple", "banana", "cherry"));

        assertTrue(stringBackwardIterator.hasNext());
        assertEquals("cherry", stringBackwardIterator.next());

        assertTrue(stringBackwardIterator.hasNext());
        assertEquals("banana", stringBackwardIterator.next());

        assertTrue(stringBackwardIterator.hasNext());
        assertEquals("apple", stringBackwardIterator.next());

        assertFalse(stringBackwardIterator.hasNext());
        assertNull(stringBackwardIterator.next());
    }

    @Test
    void testBackwardIteratorWithCustomObjects() {
        // Assuming a custom object Person
        List<Person> people = List.of(new Person("John"), new Person("Doe"), new Person("Smith"));
        Task8.BackwardIterator<Person> personBackwardIterator = new Task8.BackwardIterator<>(people);

        assertTrue(personBackwardIterator.hasNext());
        assertEquals(new Person("Smith"), personBackwardIterator.next());

        assertTrue(personBackwardIterator.hasNext());
        assertEquals(new Person("Doe"), personBackwardIterator.next());

        assertTrue(personBackwardIterator.hasNext());
        assertEquals(new Person("John"), personBackwardIterator.next());

        assertFalse(personBackwardIterator.hasNext());
        assertNull(personBackwardIterator.next());
    }

    static class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Person person = (Person) obj;
            return name.equals(person.name);
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }
    }
}
