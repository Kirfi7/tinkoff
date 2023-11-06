package edu.hw5;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task2Test {

    @Test
    void findFridaysOn13ths() {
        int year = 2023;
        List<LocalDate> expected = List.of(
            LocalDate.of(year, 1, 13),
            LocalDate.of(year, 10, 13)
        );
        List<LocalDate> result = Task2.findFridaysOn13ths(year);
        assertEquals(expected, result);
    }

    @Test
    void findFridaysOn13thsNoFridays() {
        int year = 2022;
        List<LocalDate> expected = List.of(LocalDate.of(2022, 5, 13));
        List<LocalDate> result = Task2.findFridaysOn13ths(year);
        assertEquals(expected, result);
    }

    @Test
    void findNextFriday13th() {
        LocalDate startDate = LocalDate.of(2023, 11, 1);
        LocalDate expected = LocalDate.of(2024, 9, 13);
        LocalDate result = Task2.findNextFriday13th(startDate);
        assertEquals(expected, result);
    }

    @Test
    void findNextFriday13thSameDate() {
        LocalDate startDate = LocalDate.of(2023, 11, 13);
        LocalDate expected = LocalDate.of(2024, 9, 13);
        LocalDate result = Task2.findNextFriday13th(startDate);
        assertEquals(expected, result);
    }

    @Test
    void findNextFriday13thNextYear() {
        LocalDate startDate = LocalDate.of(2023, 12, 14);
        LocalDate expected = LocalDate.of(2024, 9, 13);
        LocalDate result = Task2.findNextFriday13th(startDate);
        assertEquals(expected, result);
    }
}

