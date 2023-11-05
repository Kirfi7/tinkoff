package edu.project2.renderers;

import edu.project2.Cell;
import edu.project2.Coordinate;
import edu.project2.Maze;
import java.util.List;

public class CustomRenderer implements Render {
    @Override
    public String render(Maze maze) {
        return render(maze, null);
    }

    @Override
    public String render(Maze maze, List<Coordinate> path) {
        var sb = new StringBuilder();
        sb.append("\n");

        for (var y = 0; y < maze.getHeight(); y++) {
            for (var x = 0; x < maze.getWidth(); x++) {
                sb.append(getCellSymbol(maze, new Coordinate(x, y), path)); // получение символа для каждой
                // ячейки лабиринта
            }
            sb.append("\n"); // добавление новой строки после каждой строки лабиринта
        }

        return sb.toString(); // возвращение строкового представления лабиринта
    }

    // получение символа для каждой ячейки лабиринта
    private String getCellSymbol(Maze maze, Coordinate coordinate, List<Coordinate> path) {
        if (path != null && path.contains(coordinate)) { // если переданный путь содержит текущую координату
            return "**"; // возвращаем символ для пути
        } else if (maze.getCell(coordinate.x(), coordinate.y()) == Cell.WALL) { // если текущая ячейка - стена
            return "██"; // возвращаем символ для стены
        }

        return "  "; // возвращаем пустой символ для пустой ячейки
    }
}
