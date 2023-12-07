package edu.project4;

import edu.project4.renderers.MultiThreadsRenderer;
import edu.project4.renderers.Renderer;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ImageSizeCorrectTest {
    private final static int MIN_WIDTH = 850;
    private final static int MIN_HEIGHT = 480;
    private final static int MAX_WIDTH = 1920;
    private final static int MAX_HEIGHT = 1080;
    private final static int ITERATIONS_COUNT = 1000;
    private final static int THREADS_COUNT = 2;
    private final static double[] WEIGHTS = {0.5, 0.5, 0.5, 0.5, 0.5, 0.5};

    private ImageSizeCorrectTest() {
    }

    @Test
    void testGenerateSize() {
        for(int w = MIN_WIDTH; w < MAX_WIDTH; w += 100) {
            for(int h = MIN_HEIGHT; h < MAX_HEIGHT; h += 100) {
                Image img = Renderer.render(w, h, ITERATIONS_COUNT, WEIGHTS);
                Image imgThreads = MultiThreadsRenderer.render(
                    w, h, THREADS_COUNT, ITERATIONS_COUNT, WEIGHTS
                );

                assertThat(img.getHeight()).isEqualTo(imgThreads.getHeight()).isEqualTo(h);
                assertThat(img.getWidth()).isEqualTo(imgThreads.getWidth()).isEqualTo(w);
            }
        }
    }
}
