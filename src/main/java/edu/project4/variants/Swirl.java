package edu.project4.variants;

import edu.project4.Point;

public class Swirl implements Variants {
    @Override
    public Point calc(Point point) {
        double r2 = Math.pow(point.x(), 2) + Math.pow(point.y(), 2);
        double sin = Math.sin(r2);
        double cos = Math.cos(r2);

        return new Point(point.x() * sin - point.y() * cos, point.x() * cos + point.y() * sin);
    }
}
