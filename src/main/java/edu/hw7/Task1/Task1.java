package edu.hw7.Task1;

import java.util.concurrent.atomic.AtomicInteger;

public class Task1 {
    private final AtomicInteger counter = new AtomicInteger();

    public void increment() {
        counter.incrementAndGet();
    }

    public int getValue() {
        return counter.intValue();
    }
}
