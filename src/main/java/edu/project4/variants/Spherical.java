package edu.project4.variants;

import edu.project4.Point;

public class Spherical implements Variants {
    @Override
    public Point calc(Point point) {
        double r2 = Math.pow(point.x(), 2) + Math.pow(point.y(), 2);
        return new Point(point.x() / r2, point.y() / r2);
    }
}
