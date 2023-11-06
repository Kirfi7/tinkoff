package edu.hw5;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task3Test {

    @Test
    void parseDateValidFormat() {
        String input = "2023-11-06";
        Optional<LocalDate> expected = Optional.of(LocalDate.of(2023, 11, 6));
        Optional<LocalDate> result = Task3.parseDate(input);
        assertEquals(expected, result);
    }

    @Test
    void parseDateDifferentFormat() {
        String input = "11-06-2023";
        Optional<LocalDate> expected = Optional.of(LocalDate.of(2023, 6, 11));
        Optional<LocalDate> result = Task3.parseDate(input);
        assertEquals(expected, result);
    }

    @Test
    void parseDateToday() {
        String input = "today";
        Optional<LocalDate> expected = Optional.of(LocalDate.now());
        Optional<LocalDate> result = Task3.parseDate(input);
        assertEquals(expected, result);
    }

    @Test
    void parseDateTomorrow() {
        String input = "tomorrow";
        Optional<LocalDate> expected = Optional.of(LocalDate.now().plusDays(1));
        Optional<LocalDate> result = Task3.parseDate(input);
        assertEquals(expected, result);
    }

    @Test
    void parseDateYesterday() {
        String input = "yesterday";
        Optional<LocalDate> expected = Optional.of(LocalDate.now().minusDays(1));
        Optional<LocalDate> result = Task3.parseDate(input);
        assertEquals(expected, result);
    }

    @Test
    void parseDateAgo() {
        String input = "5 days ago";
        Optional<LocalDate> expected = Optional.of(LocalDate.now().minusDays(5));
        Optional<LocalDate> result = Task3.parseDate(input);
        assertEquals(expected, result);
    }

    @Test
    void addZero() {
        String[] input = {"1", "05", "12"};
        String[] expected = {"01", "05", "12"};

        Task3.addZero(input, 0);
        Task3.addZero(input, 1);
        Task3.addZero(input, 2);

        assertArrayEquals(expected, input);
    }

    @Test
    void isInteger() {
        String str = "12345";
        assertTrue(Task3.isInteger(str));
    }

    @Test
    void isIntegerNonNumericString() {
        String str = "123a45";
        assertFalse(Task3.isInteger(str));
    }
}
