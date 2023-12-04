package edu.hw7;

import edu.hw7.Task1.Task1;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.List;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

@Execution(ExecutionMode.CONCURRENT)
public class Task1Test {

    @RepeatedTest(100)
    void testThreadSafeIncrement() {
        int threadsCount = 20;
        int incrementsInThreadCount = 100000;

        Task1 counter = new Task1();
        Runnable incrementTask = createIncrementTask(incrementsInThreadCount, counter);

        List<Thread> threads = Stream.generate(() -> new Thread(incrementTask))
            .limit(threadsCount)
            .peek(Thread::start)
            .toList();

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        assertThat(counter.getValue())
            .isEqualTo(incrementsInThreadCount * threadsCount);
    }

    private Runnable createIncrementTask(int incrementsInThreadCount, Task1 counter) {
        return () -> {
            for (var j = 0; j < incrementsInThreadCount; j++) {
                counter.increment();
            }
        };
    }
}
