package edu.project2.renderers;

import edu.project2.Coordinate;
import edu.project2.Maze;
import java.util.List;

public interface Render {
    String render(Maze maze); // метод для рендеринга лабиринта

    String render(Maze maze, List<Coordinate> path); // метод для рендеринга лабиринта с указанным путем
}
