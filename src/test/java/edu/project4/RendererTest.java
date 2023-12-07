package edu.project4;

import edu.project4.renderers.MultiThreadsRenderer;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RendererTest {
    private final static int WIDTH = 3840;
    private final static int HEIGHT = 2160;
    private final static int ITERATIONS_COUNT = 1_000_000;
    private final static int THREADS_COUNT = 10;
    private final static int MIN_NOT_BLACK = ITERATIONS_COUNT / 5;
    private final static double[] WEIGHTS = {0.2, 0, 0, 0.5, 0.5, 0};

    private RendererTest() {
    }

    @Test
    void test() {
        Image img = MultiThreadsRenderer.render(
            WIDTH, HEIGHT, THREADS_COUNT, ITERATIONS_COUNT, WEIGHTS
        );

        int notBlackCount = 0;

        for(int w = 0; w < img.getWidth(); w++) {
            for(int h = 0; h < img.getHeight(); h++) {
                var col = img.get(w, h).getColor();

                if(col.getRed() != 0 || col.getBlue() != 0 || col.getGreen() != 0) {
                    notBlackCount++;
                }
            }
        }

        assertThat(MIN_NOT_BLACK).isLessThanOrEqualTo(notBlackCount);
    }
}
