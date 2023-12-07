package edu.project4;

import java.awt.Color;
import java.util.function.BiFunction;

public class Pixel {
    private Color color;
    private int hitCount;

    public Pixel(Color color, int hitCount) {
        this.color = color;
        this.hitCount = hitCount;
    }

    public Color getColor() {
        return color;
    }

    public int getHitCount() {
        return hitCount;
    }

    public void updateColor(Color add, int addHit, BiFunction<Color, Color, Color> updateFunction) {
        color = updateFunction.apply(color, add);
        hitCount += addHit;
    }
}
