package edu.hw9;

import edu.hw9.Task2.Task2;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Tests {

    /* private Task2Tests() {
    }

    @Test
    void testDirSearch() {
        List<String> dirList = List.of("src", "main", "java", "edu");
        StringBuilder sb = new StringBuilder();
        for (String dirName : dirList) {
            sb.append(dirName).append(File.separator);
        }

        List<String> expected = List.of(
            "hw4"
        );

        List<File> actual = Task2.findDirs(new File(sb.toString()), 20);
        assertThat(actual.size()).isEqualTo(expected.size());

        for (int i = 0; i < actual.size(); i++) {
            assertThat(actual.get(i).getPath().endsWith(expected.get(i))).isTrue();
        }
    }

    @Test
    void testFileSearch() {
        List<String> dirList = List.of("src", "main", "java", "edu", "project2");
        StringBuilder sb = new StringBuilder();
        for (String dirName : dirList) {
            sb.append(dirName).append(File.separator);
        }

        List<String> expected = List.of(
            "src/main/java/edu/project2/renderers/CustomRenderer.java",
            "src/main/java/edu/project2/Maze.java",
            "src/main/java/edu/project2/solvers/SolverBFS.java",
            "src/main/java/edu/project2/solvers/SolverDFS.java",
            "src/main/java/edu/project2/Main.java"
        );

        List<File> actual = Task2.findFiles(new File(sb.toString()), 1000, 2500, ".java");
        assertThat(actual.size()).isEqualTo(expected.size());

        for (int i = 0; i < actual.size(); i++) {
            assertThat(actual.get(i).getPath().endsWith(expected.get(i))).isTrue();
        }
    }*/
}
