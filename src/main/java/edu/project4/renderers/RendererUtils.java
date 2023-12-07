package edu.project4.renderers;

import edu.project4.Image;
import java.awt.Color;

public class RendererUtils {
    private final static double GAMMA = 2.2;

    private RendererUtils() {
    }

    public static void correction(Image img) {
        int w = img.getWidth();
        int h = img.getHeight();

        double max = 0.0;
        for (int row = 0; row < w; row++) {
            for (int col = 0; col < h; col++) {
                int hits = img.get(row, col).getHitCount();
                if (hits != 0) {
                    double normal = Math.log10(hits);
                    if (normal > max) {
                        max = normal;
                    }
                }
            }
        }

        for (int row = 0; row < w; row++) {
            for (int col = 0; col < h; col++) {
                double normal = Math.log10(img.get(row, col).getHitCount()) / max;
                img.get(row, col).updateColor(
                    null, 0,
                    (Color has, Color add) -> new Color(
                        (int) (has.getRed() * Math.pow(normal, 1 / GAMMA)),
                        (int) (has.getGreen() * Math.pow(normal, 1 / GAMMA)),
                        (int) (has.getBlue() * Math.pow(normal, 1 / GAMMA))
                    )
                );
            }
        }
    }
}
