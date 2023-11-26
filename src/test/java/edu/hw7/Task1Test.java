package edu.hw7;

import edu.hw7.Task1.Task1;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {
    private Task1Test() {
    }

    @Test
    void testThreadSafeIncrement() {
        int testCount = 100;
        int threadsCount = 100;
        int incrementsInThreadCount = 100000;

        for (int i = 0; i < testCount; i++) {
            Task1 counter = new Task1();
            Runnable r = () -> {
                for (var j = 0; j < incrementsInThreadCount; j++) {
                    counter.increment();
                }
            };

            List<Thread> l = Stream.generate(() -> new Thread(r))
                .limit(threadsCount)
                .peek(Thread::start)
                .toList();

            for (var j : l) {
                try {
                    j.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            assertThat(counter.getValue()).isEqualTo(incrementsInThreadCount * threadsCount);
        }
    }
}
