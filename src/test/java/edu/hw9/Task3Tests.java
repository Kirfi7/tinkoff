package edu.hw9;

import edu.hw9.Task3.MultiThreadsBFS;
import edu.project2.Maze;
import edu.project2.generators.Generator;
import edu.project2.generators.GeneratorDFS;
import edu.project2.solvers.Solver;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Tests {
    private Task3Tests() {
    }

    @Test void test() {
        int startWidth = 11;
        int endWidth = 51;

        int startHeight = 11;
        int endHeight = 51;

        Generator generator = new GeneratorDFS();
        Solver solver = new MultiThreadsBFS();

        for (int h = startHeight; h <= endHeight; h += 2) {
            for (int w = startWidth; w <= endWidth; w += 2) {
                Maze maze = generator.generate(h, w);
                assertThat(solver.solve(maze)).isNotEqualTo(List.of());
            }
        }
    }
}
