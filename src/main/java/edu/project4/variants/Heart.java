package edu.project4.variants;

import edu.project4.Point;

public class Heart implements Variants {
    @Override
    public Point calc(Point point) {
        double r = Math.sqrt(Math.pow(point.x(), 2) + Math.pow(point.y(), 2));

        return new Point(
            r * Math.sin(r * Math.atan(point.y() / point.x())),
            -r * Math.cos(r * Math.atan(point.y() / point.x()))
        );
    }
}
