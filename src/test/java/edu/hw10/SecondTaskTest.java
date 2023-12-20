package edu.hw10;

import edu.hw10.Task2.CacheProxy;
import edu.hw10.Task2.FibCalculator;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.assertj.core.api.Assertions.assertThat;

public class SecondTaskTest {
    private final static int ITERATION_COUNT = 45;
    private final static int MIN_GREATING_BY = 1000;
    private final static FibCalculator FIB_CALCULATOR = new FibCalculator() {
        @Override
        public long fib(int number) {
            if (number <= 1) {
                return number;
            } else {
                return fib(number - 1) + fib(number - 2);
            }
        }
    };

    @Test
    void testCacheProxy() {
        FibCalculator proxy = CacheProxy.create(FIB_CALCULATOR, FibCalculator.class);

        long timeFirstRun = getTime(proxy);
        long timeSecondRun = getTime(proxy);
        System.out.println(timeFirstRun + " : " + timeSecondRun);

        try {
            assertThat(timeFirstRun / MIN_GREATING_BY).isGreaterThan(timeSecondRun);
        } finally {
            for (var i = 0; i < ITERATION_COUNT; i++) {
                new File(
                    "src" + File.separator + "main" + File.separator
                        + "resources" + File.separator + "fib" + i + ".txt"
                ).deleteOnExit();
            }
        }
    }

    private long getTime(FibCalculator proxy) {
        long start = System.nanoTime();

        for (var i = 0; i < ITERATION_COUNT; i++) {
            proxy.fib(i);
        }

        return System.nanoTime() - start;
    }
}
