package edu.project4;

import edu.project4.variants.Heart;
import edu.project4.variants.Horseshoe;
import edu.project4.variants.Linear;
import edu.project4.variants.Sinusoidal;
import edu.project4.variants.Spherical;
import edu.project4.variants.Swirl;
import edu.project4.variants.Variants;
import java.awt.Color;

public record Coefficient(double a, double b, double c, double d, double e, double f, Color color, double[] wights) {
    private final static Variants[] VARIANTS = {
        new Linear(),
        new Sinusoidal(),
        new Spherical(),
        new Swirl(),
        new Horseshoe(),
        new Heart()
    };

    public Point calcNewPoint(Point p) {
        double resX = 0;
        double resY = 0;

        for (int i = 0; i < VARIANTS.length; i++) {
            if (wights[i] == 0) {
                continue;
            }

            Point newP = VARIANTS[i].calc(new Point(p.x() * a + p.y() * b + c, p.x() * d + p.y() * e + f));
            resX += wights[i] * newP.x();
            resY += wights[i] * newP.y();
        }

        return new Point(resX, resY);
    }
}
