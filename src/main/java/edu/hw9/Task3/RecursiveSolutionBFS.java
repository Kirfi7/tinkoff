package edu.hw9.Task3;

import edu.project2.Cell;
import edu.project2.Coordinate;
import edu.project2.Maze;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.RecursiveTask;

public class RecursiveSolutionBFS extends RecursiveTask<List<Coordinate>> {
    private final Coordinate currentCoordinate;
    private final ConcurrentMap<Coordinate, List<Coordinate>> pathToPoint;
    private final Maze maze;
    private final static List<Coordinate> DIRECTIONS = List.of(
        new Coordinate(1, 0),
        new Coordinate(-1, 0),
        new Coordinate(0, 1),
        new Coordinate(0, -1)
    );

    public RecursiveSolutionBFS(
        Coordinate currentCoordinate,
        ConcurrentMap<Coordinate, List<Coordinate>> pathToPoint,
        Maze maze
    ) {
        if (currentCoordinate == null || pathToPoint == null || maze == null) {
            throw new NullPointerException();
        }

        this.currentCoordinate = currentCoordinate;
        this.pathToPoint = pathToPoint;
        this.maze = maze;
    }

    @Override
    protected List<Coordinate> compute() {
        List<Coordinate> res = new ArrayList<>();

        for (Coordinate dir : DIRECTIONS) {
            Coordinate curNeighborCoordinate = currentCoordinate.plus(dir);

            if (maze.coordinateInBounds(curNeighborCoordinate)
                && maze.getCell(curNeighborCoordinate) == Cell.NONE
                && !pathToPoint.containsKey(curNeighborCoordinate)
            ) {
                List<Coordinate> newList = new ArrayList<>(pathToPoint.getOrDefault(currentCoordinate, List.of()));
                newList.add(curNeighborCoordinate);
                pathToPoint.put(curNeighborCoordinate, newList);

                if (curNeighborCoordinate.equals(maze.getEnd())) {
                    return newList;
                } else {
                    RecursiveSolutionBFS task = new RecursiveSolutionBFS(curNeighborCoordinate, pathToPoint, maze);
                    task.fork();
                    res.addAll(task.join());
                }
            }
        }

        return res;
    }
}
