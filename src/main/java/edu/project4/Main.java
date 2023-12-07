package edu.project4;

import edu.project4.renderers.MultiThreadsRenderer;
import edu.project4.renderers.RendererUtils;
import java.io.File;

public class Main {
    private final static int WIDTH = 720;
    private final static int HEIGHT = 720;
    private final static int ITERATIONS_COUNT = 800_000;
    private final static int THREADS_COUNT = 10;
    private final static double[] WEIGHTS = {0, 0, 0, 1, 0, 0};

    private Main() {
    }

    public static void main(String[] args) {
        Image img = MultiThreadsRenderer.render(
            WIDTH, HEIGHT, THREADS_COUNT, ITERATIONS_COUNT, WEIGHTS
        );
        ImageUtils.save(img, new File("src/main/resources/img.png"));

        RendererUtils.correction(img);
        ImageUtils.save(img, new File("src/main/resources/imgWithCor.png"));

    }
}
