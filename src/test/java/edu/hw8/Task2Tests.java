package edu.hw8;

import edu.hw8.Task2.Fibonacci;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Tests {
    private Task2Tests() {
    }

    static Stream<Arguments> argumentProvider() {
        return Stream.of(
            Arguments.of(3, new int[] {1}),
            Arguments.of(3, new int[] {1, 1}),
            Arguments.of(3, new int[] {1, 1, 2}),
            Arguments.of(3, new int[] {1, 1, 2, 3}),
            Arguments.of(3, new int[] {1, 1, 2, 3, 5}),
            Arguments.of(3, new int[] {1, 1, 2, 3, 5, 8}),
            Arguments.of(3, new int[] {1, 1, 2, 3, 5, 8, 13}),
            Arguments.of(3, new int[] {1, 1, 2, 3, 5, 8, 13, 21}),
            Arguments.of(3, new int[] {1, 1, 2, 3, 5, 8, 13, 21, 34}),
            Arguments.of(3, new int[] {1, 1, 2, 3, 5, 8, 13, 21, 34, 55}),
            Arguments.of(3, new int[] {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89}),
            Arguments.of(3, new int[] {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144})
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void test(int threadsCount, int[] expected) {
        int[] res = new int[expected.length];
        Fibonacci.getFirstNumbers(expected.length, threadsCount, res);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        assertThat(res).isEqualTo(expected);
    }
}
