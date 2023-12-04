package edu.hw9.Task3;

import edu.project2.Coordinate;
import edu.project2.Maze;
import edu.project2.solvers.Solver;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;

public class MultiThreadsBFS implements Solver {
    @Override
    public List<Coordinate> solve(Maze maze) {
        try (var fjp = new ForkJoinPool()) {
            return fjp.invoke(new RecursiveSolutionBFS(maze.getStart(), new ConcurrentHashMap<>(), maze));
        }
    }
}
