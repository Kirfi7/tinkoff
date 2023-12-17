package edu.project4.variants;

import edu.project4.Point;

public class Sinusoidal implements Variants {
    @Override
    public Point calc(Point point) {
        return new Point(Math.sin(point.x()), Math.sin(point.y()));
    }
}
