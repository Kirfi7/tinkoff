package edu.hw9.Task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StatsCollector {
    private final Map<String, Metric> metrics = new ConcurrentHashMap<>();
    private final ExecutorService es;

    public StatsCollector(int threads) {
        es = Executors.newFixedThreadPool(threads);
    }

    public void push(String name, double[] values) {
        Runnable r = () -> {
            double sum = 0;
            double max = Integer.MIN_VALUE;
            double min = Integer.MAX_VALUE;

            for (var i : values) {
                if (i > max) {
                    max = i;
                }

                if (i < min) {
                    min = i;
                }

                sum += i;
            }

            metrics.put(name, new Metric(name, min, max, sum, sum / values.length));
        };

        es.execute(r);
    }

    public List<Metric> stats() {
        List<Metric> result = new ArrayList<>();
        var keys = metrics.keySet();

        for (String name : keys) {
            result.add(metrics.get(name));
        }

        return result;
    }
}
