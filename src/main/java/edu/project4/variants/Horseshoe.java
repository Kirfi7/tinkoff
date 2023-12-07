package edu.project4.variants;

import edu.project4.Point;

public class Horseshoe implements Variants {
    @Override
    public Point calc(Point point) {
        double r = Math.sqrt(Math.pow(point.x(), 2) + Math.pow(point.y(), 2));
        return new Point((point.x() + point.y()) * (point.x() - point.y()) / r, 2 * point.x() * point.y() / r);
    }
}
