package edu.hw9;

import edu.hw9.Task1.Metric;
import edu.hw9.Task1.StatsCollector;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Tests {
    private Task1Tests() {
    }

    private static final List<String> NAMES = List.of(
        "name1",
        "name2",
        "name3",
        "name4",
        "name5",
        "name6",
        "name7"
    );

    private static final List<double[]> VALUES = List.of(
        new double[] {1, 2, 3, 4, 5},
        new double[] {10, 20, 30, 40, 50},
        new double[] {0.1, 0.2, 0.3, 0.4, 0.5},
        new double[] {1, 0.2, 3, 0.4, 5},
        new double[] {1, 2.1, 3.1, 4.1, 5},
        new double[] {4, 0, 0.5, 0},
        new double[] {4, 4, 4, 4}
    );

    private static final List<Metric> EXPECTED = List.of(
        new Metric("name1", 1, 5, 15, 3),
        new Metric("name2", 10, 50, 150, 30),
        new Metric("name3", 0.1, 0.5, 1.5, 0.3),
        new Metric("name4", 0.2, 5, 9.6, 1.92),
        new Metric("name5", 1, 5, 15.3, 3.06),
        new Metric("name6", 0, 4, 4.5, 1.125),
        new Metric("name7", 4, 4, 16, 4)
    );

    @Test
    void test() {
        StatsCollector sc = new StatsCollector(2);
        Thread[] threads = new Thread[EXPECTED.size()];

        for (var i = 0; i < EXPECTED.size(); i++) {
            int finalI = i;
            threads[i] = new Thread(() -> sc.push(NAMES.get(finalI), VALUES.get(finalI)));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        List<Metric> stats = sc.stats();
        assertThat(stats.size()).isEqualTo(EXPECTED.size());

        for (Metric metric : stats) {
            var exp = EXPECTED.stream().filter(x -> x.name().equals(metric.name())).findFirst().get();
            assertThat(metric.min()).isBetween(exp.min() - 0.00001, exp.min() + 0.00001);
            assertThat(metric.max()).isBetween(exp.max() - 0.00001, exp.max() + 0.00001);
            assertThat(metric.sum()).isBetween(exp.sum() - 0.00001, exp.sum() + 0.00001);
            assertThat(metric.average()).isBetween(exp.average() - 0.00001, exp.average() + 0.00001);
        }
    }
}
