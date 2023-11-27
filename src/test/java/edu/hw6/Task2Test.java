package edu.hw6;

import edu.hw6.Task2.Task2;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {
    private Task2Test() {
    }

    @Test
    void test() {
        var file = new File("test.txt");

        writeInFileAnyPhrase(file);
        cloneFile(file);

        File copy1 = new File("test - копия.txt");
        assertThat(copy1.exists()).isTrue();

        File copy2 = new File("test - копия (2).txt");
        assertThat(copy2.exists()).isTrue();

        testFileContent(file, copy1, copy2);
    }

    private void writeInFileAnyPhrase(File file) {
        String str = "wsdfjkn\n\n\nfgv1\"'fs123e123\"";
        try (FileOutputStream writer = new FileOutputStream(file)) {
            for (int i = 0; i < str.length(); i++) {
                writer.write(str.charAt(i));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void cloneFile(File file) {
        try {
            Task2.cloneFile(file.toPath());
            Task2.cloneFile(file.toPath());
        } catch (Exception e) {
            deleteFiles();
            throw new RuntimeException(e);
        }
    }

    private void testFileContent(File file, File copy1, File copy2) {
        try (
            var reader1 = new FileInputStream(file);
            var reader2 = new FileInputStream(copy1);
            var reader3 = new FileInputStream(copy2);

        ) {
            var r1 = reader1.readAllBytes();
            var r2 = reader2.readAllBytes();
            var r3 = reader3.readAllBytes();

            assertThat(r1.length == r2.length && r2.length == r3.length).isTrue();

            for (int i = 0; i < r1.length; i++) {
                assertThat(r1[i] == r2[i] && r2[i] == r3[i]).isTrue();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            deleteFiles();
        }
    }

    private void deleteFiles() {
        try {
            Files.deleteIfExists(Path.of("test.txt"));
            Files.deleteIfExists(Path.of("test - копия.txt"));
            Files.deleteIfExists(Path.of("test - копия (2).txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
