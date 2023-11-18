package edu.hw6;

import edu.hw6.Task5.Task5;
import java.util.concurrent.FutureTask;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task5Test {
    private Task5Test() {
    }

    @Test
    void testAPINews() {
        FutureTask<Long[]> task1 = new FutureTask<>(Task5::hackerNewsTopStories);
        var a = new Thread(task1);
        a.start();

        FutureTask<String> task2 = new FutureTask<>(() -> Task5.news(37570037));
        var b = new Thread(task2);
        b.start();

        try {
            assertThat(task1.get().length > 0).isTrue();
            assertThat(task2.get())
                .isEqualTo("JDK 21 Release Notes");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
