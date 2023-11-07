package edu.project1;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class GetSessionResultTest {
    private GetSessionResultTest() {
    }

    static Stream<Arguments> finalResultArgumentProvider() {
        return Stream.of(
            Arguments.of("road", new char[] {'r', 'o', '*', '*'}, 10, 10, SessionResult.Defeat.class),
            Arguments.of("road", new char[] {'r', 'o', 'a', 'd'}, 3, 3, SessionResult.Defeat.class),
            Arguments.of("road", new char[] {'r', 'o', 'a', 'd'}, 10, 4, SessionResult.Win.class),
            Arguments.of("road", new char[] {'r', 'o', '*', '*'}, 10, 4, null),
            Arguments.of("road", new char[] {'r', '*', 'a', 'd'}, 10, 9, null),
            Arguments.of("road", new char[] {'*', '*', '*', '*'}, 10, 9, null),
            Arguments.of("road", new char[] {'*', '*', '*', '*'}, 1, 0, null),
            Arguments.of("road", new char[] {'*', '*', '*', '*'}, 1, 0, null)
        );
    }

    static Stream<Arguments> intermediateResultArgumentProvider() {
        return Stream.of(
            Arguments.of("road", new char[] {'r', 'o', '*', 'd'}, 'd', 10, 0, SessionResult.FailedGuess.class),
            Arguments.of("road", new char[] {'r', 'o', '*', '*'}, 'n', 10, 0, SessionResult.FailedGuess.class),
            Arguments.of("road", new char[] {'r', 'o', '*', '*'}, 'd', 10, 0, SessionResult.SuccessfulGuess.class),
            Arguments.of("road", new char[] {'*', '*', '*', '*'}, 'd', 10, 0, SessionResult.SuccessfulGuess.class)
        );
    }

    @ParameterizedTest
    @MethodSource("intermediateResultArgumentProvider")
    void testGetIntermediateResult(
        String word,
        char[] userSequence,
        char input,
        int maxMistakesAllowed,
        int mistakeCount,
        Class<SessionResult> expectedIntermediateResult
    ) {
        var intermediateResult =
            ResultUtils.getIntermediateResult(word, userSequence, input, maxMistakesAllowed, mistakeCount);

        assertThat(intermediateResult).isExactlyInstanceOf(expectedIntermediateResult);
    }

    @ParameterizedTest
    @MethodSource("finalResultArgumentProvider")
    void testGetFinalResult(
        String word,
        char[] userSequence,
        int maxMistakesAllowed,
        int mistakeCount,
        Class<SessionResult> expectedFinalResult
    ) {
        var finalResult = ResultUtils.getFinalResultOrNull(word, userSequence, maxMistakesAllowed, mistakeCount);

        if (finalResult == null) {
            assertThat(finalResult).isEqualTo(expectedFinalResult);
        } else {
            assertThat(finalResult).isExactlyInstanceOf(expectedFinalResult);
        }
    }
}
