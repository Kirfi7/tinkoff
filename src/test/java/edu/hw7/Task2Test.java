package edu.hw7;

import edu.hw7.Task2.Task2;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {
    private Task2Test() {
    }

    @Test
    void testParallelFactorialCalculation() {
        var toFactorial = 40;

        var factorialResults = new BigInteger[toFactorial];
        factorialResults[0] = BigInteger.valueOf(1);
        assertThat(Task2.getFactorial((byte) 1)).isEqualTo(factorialResults[0]);

        for (var i = 2; i <= toFactorial; i++) {
            factorialResults[i - 1] = BigInteger.valueOf(i).multiply(factorialResults[i - 2]);

            assertThat(Task2.getFactorial((byte) i)).isEqualTo(factorialResults[i - 1]);
        }
    }
}
