package edu.hw9.Task2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class RecursiveFileSearch extends RecursiveTask<List<File>> {
    private final File startDir;
    private final long minSize;
    private final long maxSize;
    private final String extension;

    public RecursiveFileSearch(File startDir, long minSize, long maxSize, String extension) {
        if (startDir == null || !startDir.exists() || minSize > maxSize) {
            throw new NullPointerException();
        }

        this.startDir = startDir;
        this.minSize = minSize;
        this.maxSize = maxSize;
        this.extension = extension;
    }

    @Override
    protected List<File> compute() {
        File[] files = startDir.listFiles();
        if (files == null) {
            return List.of();
        }

        List<File> res = new ArrayList<>();

        for (File file : files) {
            if (file.isFile() && file.length() >= minSize
                && file.length() <= maxSize && file.getName().endsWith(extension)
            ) {
                res.add(file);
            } else if (file.isDirectory()) {
                RecursiveFileSearch task = new RecursiveFileSearch(file, minSize, maxSize, extension);
                task.fork();
                res.addAll(task.join());
            }
        }

        return res;
    }
}
