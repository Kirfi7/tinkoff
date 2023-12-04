package edu.hw7;

import edu.hw7.Task4.Task4;
import java.util.concurrent.FutureTask;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {
    private Task4Test() {
    }

    static Stream<Arguments> calculatePiMultiThread() {
        return Stream.of(
            Arguments.of(
                100, 1, Math.PI, 1
            ),
            Arguments.of(
                1000, 5, Math.PI, 0.5
            ),
            Arguments.of(
                10000, 10, Math.PI, 0.4
            ),
            Arguments.of(
                100000, 20, Math.PI, 0.2
            ),
            Arguments.of(
                1000000, 50, Math.PI, 0.1
            ),
            Arguments.of(
                10000000, 100, Math.PI, 0.05
            )
        );
    }

    private static Stream<Arguments> getTimeStatisticsTestData() {
        return Stream.of(
            Arguments.of(1000000, 1, 3),
            Arguments.of(1000000, 5, 3),
            Arguments.of(1000000, 10, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("calculatePiMultiThread")
    void calculatePiThread(int n, int threadsCount, double expected, double inaccuracy) {
        var actual = Task4.calculatePiMultiThread(n, threadsCount);

        assertThat(actual)
            .isBetween(expected - inaccuracy, expected + inaccuracy);
    }

    @ParameterizedTest
    @MethodSource("getTimeStatisticsTestData")
    void getTimeStatistics(int n, int maxThreadsCount, int testCount) {
        String[] results = Task4.getAndPrintTimeStatistics(n, maxThreadsCount, testCount);

        assertEquals(maxThreadsCount, results.length);

        for (String result : results) {
            assertThat(result)
                .contains("time:")
                .contains("inaccuracy:");
        }
    }

    @ParameterizedTest
    @MethodSource("getTimeStatisticsTestData")
    void getTimeAnotherStatistics(int n, int maxThreadsCount, int testCount) {
        String[] results = Task4.getTimeStatistics(n, maxThreadsCount, testCount);

        assertEquals(maxThreadsCount, results.length);

        for (String result : results) {
            assertThat(result)
                .contains("time:")
                .contains("inaccuracy:");
        }
    }
}

