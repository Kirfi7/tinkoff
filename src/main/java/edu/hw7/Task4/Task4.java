package edu.hw7.Task4;

import java.security.SecureRandom;
import java.util.List;
import java.util.concurrent.FutureTask;
import java.util.stream.Stream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task4 {
    private final static double PARTS_COUNT = 4;
    private final static Logger LOGGER = LogManager.getLogger();

    private Task4() {
    }

    public static double calculatePi(int n) {
        int circleCount = 0;
        SecureRandom rand = new SecureRandom();

        for (int i = 0; i < n; i++) {
            double x = rand.nextDouble();
            double y = rand.nextDouble();

            if (x * x + y * y <= 1) {
                circleCount++;
            }
        }

        return PARTS_COUNT * circleCount / n;
    }

    public static double calculatePiMultiThread(int n, int totalThreadCount) {
        FutureTask<Double> task = new FutureTask<>(
            () -> calculatePi(n / totalThreadCount)
        );

        List<FutureTask<Double>> threads = Stream.generate(() -> task)
            .limit(totalThreadCount)
            .peek(x -> new Thread(x).start())
            .toList();

        return threads.stream()
            .map(
                x -> {
                    try {
                        return x.get();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            ).reduce(0.0, Double::sum) / totalThreadCount;
    }

    public static String[] getAndPrintTimeStatistics(int n, int maxThreadsCount, int testCount) {
        String[] statistics = getTimeStatistics(n, maxThreadsCount, testCount);
        for (int i = 0; i < statistics.length; i++) {
            LOGGER.info((i + 1) + " : " + statistics[i]);
        }
        return statistics;
    }

    public static String[] getTimeStatistics(int n, int maxThreadsCount, int testCount) {
        String[] results = new String[maxThreadsCount];

        for (int i = 0; i < maxThreadsCount; i++) {
            System.gc();
            long start = System.nanoTime();
            double resSumPI = 0;
            for (int j = 0; j < testCount; j++) {
                resSumPI += calculatePiMultiThread(n, i + 1);
            }

            long time = (System.nanoTime() - start) / testCount;
            double inaccuracy = Math.abs(Math.PI - resSumPI / testCount);
            results[i] = String.format("time: %s, inaccuracy: %s", time, inaccuracy);
        }

        return results;
    }
}
