package edu.project4;

import java.awt.Color;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Image {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    private final ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
    private final Pixel[][] pixels;
    private final int width;
    private final int height;

    public Image(int wight, int height) {
        this.width = wight;
        this.height = height;

        pixels = new Pixel[wight][height];
        for (int w = 0; w < wight; w++) {
            for (int h = 0; h < height; h++) {
                pixels[w][h] = new Pixel(new Color(0), 0);
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Pixel get(int x, int y) {
        try {
            readLock.lock();
            return pixels[x][y];
        } finally {
            readLock.unlock();
        }
    }

    public Pixel get(Point point) {
        try {
            readLock.lock();
            return pixels[(int) point.x()][(int) point.y()];
        } finally {
            readLock.unlock();
        }
    }

    public void mergeColor(int x, int y, Color merge, int addHit) {
        try {
            writeLock.lock();
            pixels[x][y].updateColor(
                merge,
                addHit,
                (Color has, Color add) -> new Color(
                    (has.getRed() + add.getRed()) / 2,
                    (has.getGreen() + add.getGreen()) / 2,
                    (has.getBlue() + add.getBlue()) / 2
                )
            );
        } finally {
            writeLock.unlock();
        }
    }
}
