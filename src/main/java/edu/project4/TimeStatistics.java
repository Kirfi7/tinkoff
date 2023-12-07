package edu.project4;

import edu.project4.renderers.MultiThreadsRenderer;
import edu.project4.renderers.Renderer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TimeStatistics {
    private final static Logger LOGGER = LogManager.getLogger();
    private final static int WIDTH = 3840;
    private final static int HEIGHT = 2160;
    private final static int ITERATIONS_COUNT = 10_000;
    private final static int ITERATIONS_TEST_COUNT = 10;
    private final static int MAX_THREADS_COUNT = 10;
    private final static double[] WEIGHTS = {0, 0, 0, 0.88, 0.32, 0}; // max weight sum for 4K = 1.2

    private TimeStatistics() {
    }

    public static void get() {
        System.gc();
        long startOneThreadTime = System.nanoTime();
        for (var i = 0; i < ITERATIONS_TEST_COUNT; i++) {
            Renderer.render(WIDTH, HEIGHT, ITERATIONS_COUNT, WEIGHTS);
        }
        long endOneThreadTime = System.nanoTime();

        LOGGER.info("one thread time: " + ((endOneThreadTime - startOneThreadTime) / ITERATIONS_TEST_COUNT));

        for (var t = 2; t <= MAX_THREADS_COUNT; t++) {
            System.gc();
            long startTime = System.nanoTime();

            for (var i = 0; i < ITERATIONS_TEST_COUNT; i++) {
                MultiThreadsRenderer.render(WIDTH, HEIGHT, t, ITERATIONS_COUNT, WEIGHTS);
            }

            long endTime = System.nanoTime();
            long time = (endTime - startTime) / ITERATIONS_TEST_COUNT;
            LOGGER.info(String.format("thread count: %d, time: %d", t, time));
        }


        /*
        my:

        one thread time: 334820430
        thread count: 2, time: 312282890
        thread count: 3, time: 286616841
        thread count: 4, time: 352641913
        thread count: 5, time: 350751811
        thread count: 6, time: 351493189
        thread count: 7, time: 353628151
        thread count: 8, time: 356084629
        thread count: 9, time: 351618931
        thread count: 10, time: 332584318
        */
    }
}
