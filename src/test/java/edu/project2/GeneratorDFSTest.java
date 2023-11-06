package edu.project2;

import edu.project2.generators.GeneratorDFS;
import edu.project2.solvers.SolverAStar;
import edu.project2.solvers.SolverBFS;
import edu.project2.solvers.SolverDFS;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class GeneratorDFSTest {
    private GeneratorDFSTest() {
    }

    @Test
    void testGenerationMaze() {
        var startWidth = 11;
        var endWidth = 51;

        var startHeight = 11;
        var endHeight = 51;

        var generator = new GeneratorDFS();
        var solverAStar = new SolverAStar();
        var solverBFS = new SolverBFS();
        var solverDFS = new SolverDFS();

        for (var h = startHeight; h <= endHeight; h += 2) {
            for (var w = startWidth; w <= endWidth; w += 2) {
                var maze = generator.generate(h, w);

                var as = solverAStar.solve(maze);
                var bfs = solverBFS.solve(maze);
                var dfs = solverDFS.solve(maze);

                assertThat(as).isNotEqualTo(List.of());
                assertThat(bfs).isNotEqualTo(List.of());
                assertThat(dfs).isNotEqualTo(List.of());
            }
        }
    }
}
