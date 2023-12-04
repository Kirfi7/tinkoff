package edu.hw9.Task2;

import java.io.File;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Task2 {
    private Task2() {
    }

    public static List<File> findDirs(File startFile, int countFilesInDir) {
        try (var fjp = new ForkJoinPool()) {
            return fjp.invoke(new RecursiveDirectorySearch(startFile, countFilesInDir));
        }
    }

    public static List<File> findFiles(File startFile, long minSize, long maxSize, String extension) {
        try (var fjp = new ForkJoinPool()) {
            return fjp.invoke(new RecursiveFileSearch(startFile, minSize, maxSize, extension));
        }
    }
}
