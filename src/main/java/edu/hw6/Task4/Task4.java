package edu.hw6.Task4;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;

public class Task4 {
    private Task4() {
    }

    public static void printPhraseInFile(Path path) throws IOException {
        try (OutputStream os = Files.newOutputStream(path);
             CheckedOutputStream checkedOS = new CheckedOutputStream(os, new CRC32());
             BufferedOutputStream bufferedOs = new BufferedOutputStream(checkedOS);
             OutputStreamWriter osWriter = new OutputStreamWriter(bufferedOs, StandardCharsets.UTF_8);
             PrintWriter writer = new PrintWriter(osWriter);
        ) {
            writer.print("Programming is learned by writing programs. - Brian Kernighan");
        }
    }
}
