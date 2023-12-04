package edu.hw9.Task2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class RecursiveDirectorySearch extends RecursiveTask<List<File>> {
    private final int countFilesInDir;
    private final File startDir;

    public RecursiveDirectorySearch(File startDir, int countFilesInDir) {
        if (countFilesInDir < 0 || startDir == null || !startDir.exists()) {
            throw new NullPointerException();
        }

        this.startDir = startDir;
        this.countFilesInDir = countFilesInDir;
    }

    @Override
    protected List<File> compute() {
        File[] files = startDir.listFiles();
        File[] dirs = startDir.listFiles(File::isDirectory);

        if (files == null || dirs == null) {
            return List.of();
        }

        List<File> result = new ArrayList<>();
        if (files.length >= countFilesInDir) {
            result.add(startDir);
        }

        for (File dir : dirs) {
            RecursiveDirectorySearch task = new RecursiveDirectorySearch(dir, countFilesInDir);
            task.fork();
            result.addAll(task.join());
        }

        return result;
    }
}
