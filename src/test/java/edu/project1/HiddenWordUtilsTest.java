package edu.project1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class HiddenWordUtilsTest {
    private HiddenWordUtilsTest() {
    }

    static Stream<Arguments> haveInSequenceArgumentProvider() {
        return Stream.of(
            Arguments.of(new char[] {'0'}, '0', true),
            Arguments.of(new char[] {'0', '1', 'a', '%', '7', 't', ','}, 't', true),
            Arguments.of(new char[] {'0', '1', 'a', '%', '7', 't', ','}, 'k', false),
            Arguments.of(new char[] {}, 'k', false)
        );
    }

    static Stream<Arguments> openLettersArgumentProvider() {
        return Stream.of(
            Arguments.of("road", new char[] {'*', '*', '*', '*'}, 'r', new char[] {'r', '*', '*', '*'}),
            Arguments.of("road", new char[] {'*', '*', '*', '*'}, 'o', new char[] {'*', 'o', '*', '*'}),
            Arguments.of("road", new char[] {'*', '*', '*', '*'}, 'k', new char[] {'*', '*', '*', '*'}),
            Arguments.of("tetris",
                new char[] {'*', '*', '*', '*', '*', '*'}, 't', new char[] {'t', '*', 't', '*', '*', '*'})
        );
    }

    @ParameterizedTest
    @MethodSource("haveInSequenceArgumentProvider")
    void testHaveInSequence(char[] sequence, char symbol, boolean expected) {
        var actual = HiddenWordUtils.haveInCharArray(sequence, symbol);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("openLettersArgumentProvider")
    void testOpenLetters(String word, char[] sequence, char letter, char[] expected) {
        HiddenWordUtils.openLettersInSequence(sequence, word, letter);
        assertThat(sequence).isEqualTo(expected);
    }
}
