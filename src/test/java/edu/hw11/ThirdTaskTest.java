package edu.hw11;

import edu.hw11.Task3.Task3;
import org.junit.jupiter.api.Test;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import static org.assertj.core.api.Assertions.assertThat;

public class ThirdTaskTest {
    private final static int ITERATIONS_COUNT = 40;

    private ThirdTaskTest() {
    }

    @Test
    void testNewClassAndMethod() {
        for(var n = 0; n < ITERATIONS_COUNT; n++) {
            AtomicLong actual = new AtomicLong();

            int finalN = n;
            Thread thread = new Thread(() -> actual.set(Task3.generateFibAndGet(finalN)));
            thread.start();

            long expected = fib(n);

            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            assertThat(actual.get()).isEqualTo(expected);
        }
    }

    private long fib(int n) {
        if(n <= 1) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }
}

