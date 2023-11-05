package edu.project2.solvers;

import edu.project2.Cell;
import edu.project2.Coordinate;
import edu.project2.Maze;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class SolverAStar implements Solver {
    @Override
    public List<Coordinate> solve(Maze maze) {
        var width = maze.getWidth();
        var height = maze.getHeight();
        var start = maze.getStart();
        var end = maze.getEnd();

        if (!isValid(width, height, start) || !isValid(width, height, end)
            || !isUnBlocked(maze, start) || !isUnBlocked(maze, end)) {
            return List.of();
        }

        var closedList = new boolean[width][height];
        var cellDetails = new Node[width][height];
        cellDetails[start.x()][start.y()] = new Node(start, 0, 0);

        var openList = new PriorityQueue<Details>((o1, o2) -> (int) Math.round(o1.value - o2.value)) {{
            add(new Details(start, 0));
        }};

        while (!openList.isEmpty()) {
            Details current = openList.poll();
            closedList[current.coordinate.x()][current.coordinate.y()] = true;

            for (var direction : getDirections()) {
                Coordinate neighbour =
                    new Coordinate(
                        current.coordinate.x() + direction.x(),
                        current.coordinate.y() + direction.y()
                    );

                if (!isValid(width, height, neighbour)) {
                    continue;
                }

                if (cellDetails[neighbour.x()] == null) {
                    cellDetails[neighbour.x()] = new Node[height];
                }

                if (cellDetails[neighbour.x()][neighbour.y()] == null) {
                    cellDetails[neighbour.x()][neighbour.y()] =
                        new Node(new Coordinate(-1, -1), -1, -1);
                }

                if (neighbour.equals(end)) {
                    cellDetails[neighbour.x()][neighbour.y()] = new Node(
                        current.coordinate,
                        cellDetails[neighbour.x()][neighbour.y()].costToThis,
                        cellDetails[neighbour.x()][neighbour.y()].costEstimationToEnd
                    );

                    return tracePath(cellDetails, start, end);
                }

                if (!closedList[neighbour.x()][neighbour.y()] && isUnBlocked(maze, neighbour)) {
                    double gNew = cellDetails[current.coordinate.x()][current.coordinate.y()].costToThis + 1;
                    double fNew = gNew + neighbour.calculateDistance(end);

                    if (cellDetails[neighbour.x()][neighbour.y()].costEstimationToEnd == -1
                        || cellDetails[neighbour.x()][neighbour.y()].costEstimationToEnd > fNew) {
                        openList.add(new Details(neighbour, fNew));

                        cellDetails[neighbour.x()][neighbour.y()] = new Node(
                            current.coordinate,
                            gNew,
                            cellDetails[neighbour.x()][neighbour.y()].costEstimationToEnd
                        );
                    }
                }
            }
        }

        return List.of();
    }

    private List<Coordinate> getDirections() {
        return List.of(
            new Coordinate(1, 0),
            new Coordinate(-1, 0),
            new Coordinate(0, 1),
            new Coordinate(0, -1)
        );
    }

    private boolean isValid(int width, int height, Coordinate point) {
        return point.x() >= 0 && point.x() < width && point.y() >= 0 && point.y() < height;
    }

    private boolean isUnBlocked(Maze maze, Coordinate point) {
        return isValid(maze.getWidth(), maze.getHeight(), point) && maze.getCell(point) == Cell.NONE;
    }

    private List<Coordinate> tracePath(Node[][] nodes, Coordinate start, Coordinate end) {
        var path = new ArrayDeque<Coordinate>() {{
            add(end);
        }};

        var nextCell = nodes[end.x()][end.y()].coordinate;
        var row = nextCell.x();
        var col = nextCell.y();

        while (nodes[row][col].coordinate != nextCell) {
            path.add(new Coordinate(row, col));
            nextCell = nodes[row][col].coordinate;
            row = nextCell.x();
            col = nextCell.y();
        }

        path.add(start);

        var res = new ArrayList<>(path);
        Collections.reverse(res);
        return res;
    }

    private record Details(Coordinate coordinate, double value) {
    }

    public record Node(Coordinate coordinate, double costToThis, double costEstimationToEnd) {
    }
}
