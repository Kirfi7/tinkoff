package edu.project4.renderers;

import edu.project4.Coefficient;
import edu.project4.Image;
import edu.project4.Point;

class RenderColor implements Runnable {
    private final Image img;
    private final Coefficient coef;
    private final Point randPoint;
    private final double xmin;
    private final double xmax;
    private final double ymin;
    private final double ymax;

    RenderColor(
        Image img,
        Coefficient coef,
        Point randPoint,
        double xmin,
        double xmax,
        double ymin,
        double ymax
    ) {
        this.img = img;
        this.coef = coef;
        this.randPoint = randPoint;

        this.xmin = xmin;
        this.xmax = xmax;
        this.ymin = ymin;
        this.ymax = ymax;
    }

    @Override
    public void run() {
        int x1 = (int) ((xmax - randPoint.x()) / (xmax - xmin) * img.getWidth());
        int y1 = (int) ((ymax - randPoint.y()) / (ymax - ymin) * img.getHeight());

        if (x1 >= 0 && x1 < img.getWidth() && y1 >= 0 && y1 < img.getHeight()) {
            img.mergeColor(x1, y1, coef.color(), 1);
        }
    }
}
