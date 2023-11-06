package edu.project1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class StartGameTest {
    private StartGameTest() {
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 15, Integer.MAX_VALUE})
    void successfulCreateGameTest(int maxMistakeAllowed) {
        assertDoesNotThrow(() -> new Game(maxMistakeAllowed));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -3, -100, Integer.MIN_VALUE})
    void failedCreateGameTest(int maxMistakeAllowed) {
        assertThatThrownBy(() -> new Game(maxMistakeAllowed))
            .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
