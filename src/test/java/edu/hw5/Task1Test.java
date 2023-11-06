package edu.hw5;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task1Test {

    @Test
    void calculateAverageSessionDurationInMinutes() {
        List<String> sessions = Arrays.asList(
            "2023-11-06, 10:30 - 2023-11-06, 11:45",
            "2023-11-06, 12:00 - 2023-11-06, 12:45",
            "2023-11-06, 14:30 - 2023-11-06, 15:30"
        );

        LocalTime expected = LocalTime.of(1, 0);
        LocalTime result = Task1.calculateAverageSessionDurationInMinutes(sessions);
        assertEquals(expected, result);
    }

    @Test
    void calculateAverageSessionDurationInMinutesSingleSession() {
        List<String> sessions = Arrays.asList(
            "2023-11-06, 10:30 - 2023-11-06, 11:45"
        );

        LocalTime expected = LocalTime.of(1, 15);
        LocalTime result = Task1.calculateAverageSessionDurationInMinutes(sessions);
        assertEquals(expected, result);
    }
}
