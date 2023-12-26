package edu.hw11;

import edu.hw11.Task2.ArithmeticUtils;
import edu.hw11.Task2.Task2;
import org.junit.jupiter.api.Test;
import java.security.SecureRandom;
import java.util.Random;
import static org.assertj.core.api.Assertions.assertThat;

public class SecondTaskTest {
    private SecondTaskTest() {
    }

    @Test
    void testChangeBehaviorClass() {
        Random rand = new SecureRandom();

        for(int i = 0; i < 10000; i++) {
            int firstValue = rand.nextInt(-10000, 10000);
            int secondValue = rand.nextInt(-10000, 10000);

            int sum = new ArithmeticUtils().sum(firstValue, secondValue);
            int multiply = Task2.getResult(ArithmeticUtils.class, "sum", firstValue, secondValue);

            assertThat(multiply).isEqualTo(firstValue * secondValue).isNotEqualTo(sum);
        }
    }
}
