package edu.hw6.Task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Task2 {
    private Task2() {
    }

    public static void cloneFile(Path path) {
        if (Files.notExists(path)) {
            throw new IllegalArgumentException();
        }

        String fileName = path.getFileName().toString();
        String fileExtension = "";

        int extensionIndex = fileName.lastIndexOf(".");
        if (extensionIndex > 0) {
            fileExtension = fileName.substring(extensionIndex);
            fileName = fileName.substring(0, extensionIndex);
        }

        Path copyPath = path;
        int copyNumber = 0;

        while (Files.exists(copyPath)) {
            copyNumber++;
            String copyName = fileName + " - копия";
            if (copyNumber > 1) {
                copyName += " (" + copyNumber + ")";
            }
            copyName += fileExtension;

            copyPath = path.resolveSibling(copyName);
        }

        try {
            Files.copy(path, copyPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
