package edu.hw8.Task2;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class FixedThreadPool implements ThreadPool {
    private AtomicInteger freeThreads;
    private LinkedBlockingQueue<Runnable> queue;

    public void create(int threadsCount) {
        if (freeThreads != null) {
            throw new IllegalArgumentException();
        }

        freeThreads = new AtomicInteger(threadsCount);
        queue = new LinkedBlockingQueue<>();
    }

    @Override
    public void start() {
    }

    @Override
    public void execute(Runnable runnable) {
        Thread thread = new Thread(
            () -> {
                runnable.run();
                synchronized (queue) {
                    if (queue == null) {
                        return;
                    }

                    while (!queue.isEmpty()) {
                        queue.poll().run();
                    }
                }

                freeThreads.incrementAndGet();
            }
        );

        synchronized (freeThreads) {
            if (freeThreads.get() > 0) {
                freeThreads.decrementAndGet();
                thread.start();
            } else {
                queue.add(thread);
            }
        }
    }

    @Override
    public void close() {
        freeThreads = null;
        queue = null;
    }
}
