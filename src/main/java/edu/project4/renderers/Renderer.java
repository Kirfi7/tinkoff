package edu.project4.renderers;

import edu.project4.Coefficient;
import edu.project4.Image;
import edu.project4.Point;
import java.awt.Color;
import java.security.SecureRandom;
import java.util.Random;

public class Renderer {
    private final static int MIN_COLOR_BYTE = 0;
    private final static int MAX_COLOR_BYTE = 256;
    private final static int COEFFICIENTS_COUNT = 30;
    private final static double MIN_COEFFICIENT = -1.5;
    private final static double MAX_COEFFICIENT = 1.5;

    private Renderer() {
    }

    public static Image render(
        int width,
        int height,
        int iteration,
        double[] weights
    ) {
        Random rand = new SecureRandom();
        Image img = new Image(width, height);

        Coefficient[] coefficients = new Coefficient[COEFFICIENTS_COUNT];

        double xmax = Double.MIN_VALUE;
        double xmin = Double.MAX_VALUE;
        double ymax = Double.MIN_VALUE;
        double ymin = Double.MAX_VALUE;

        for (var i = 0; i < coefficients.length; i++) {
            while (true) {
                double a = rand.nextDouble(MIN_COEFFICIENT, MAX_COEFFICIENT);
                double b = rand.nextDouble(MIN_COEFFICIENT, MAX_COEFFICIENT);
                double d = rand.nextDouble(MIN_COEFFICIENT, MAX_COEFFICIENT);
                double e = rand.nextDouble(MIN_COEFFICIENT, MAX_COEFFICIENT);

                if (a * a + d * d < 1
                    && b * b + e * e < 1
                    && a * a + b * b + d * d + e * e < 1 + (a * e - b * d) * (a * e - b * d)
                ) {
                    double c = rand.nextDouble(-1, 1);
                    double f = rand.nextDouble(-1, 1);

                    Color newCol = new Color(
                        rand.nextInt(MIN_COLOR_BYTE, MAX_COLOR_BYTE),
                        rand.nextInt(MIN_COLOR_BYTE, MAX_COLOR_BYTE),
                        rand.nextInt(MIN_COLOR_BYTE, MAX_COLOR_BYTE)
                    );

                    xmax = Math.max(xmax, a + b + c);
                    xmin = Math.min(xmin, a + b + c);
                    ymax = Math.max(ymax, d + e + f);
                    ymin = Math.min(ymin, d + e + f);
                    coefficients[i] = new Coefficient(a, b, c, d, e, f, newCol, weights);
                    break;
                }
            }
        }

        Point randPoint = new Point(rand.nextDouble(), rand.nextDouble());

        for (int i = 0; i < iteration; i++) {
            Coefficient coef = coefficients[rand.nextInt(coefficients.length)];
            randPoint = coef.calcNewPoint(randPoint);

            int x1 = (int) ((xmax - randPoint.x()) / (xmax - xmin) * img.getWidth());
            int y1 = (int) ((ymax - randPoint.y()) / (ymax - ymin) * img.getHeight());

            if (x1 >= 0 && x1 < img.getWidth() && y1 >= 0 && y1 < img.getHeight()) {
                img.mergeColor(x1, y1, coef.color(), 1);
            }
        }

        return img;
    }
}
