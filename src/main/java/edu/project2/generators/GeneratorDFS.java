package edu.project2.generators;

import edu.project2.Cell;
import edu.project2.Coordinate;
import edu.project2.Maze;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class GeneratorDFS implements Generator {
    private final Random random = new Random();
    private Cell[][] maze;

    @Override
    public Maze generate(int height, int width) {
        if (height % 2 == 0 || width % 2 == 0) {
            throw new IllegalArgumentException(); // выбрасывает исключение, если высота или ширина - четные числа
        }

        maze = new Cell[width][height]; // инициализация лабиринта

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                maze[x][y] = Cell.WALL; // заполнение лабиринта стенами
            }
        }

        var stack = new Stack<Coordinate>(); // создание стека для отслеживания пути
        var start = new Coordinate(1, 1); // начальная координата
        maze[start.x()][start.y()] = Cell.NONE; // установка начальной координаты как пустого пространства
        stack.push(start); // добавление начальной координаты в стек

        while (!stack.isEmpty()) {
            var currentCell = stack.peek(); // текущая ячейка

            var neighbors = getUnvisitedNeighbors(currentCell, height, width); // получение списка непосещенных соседей
            if (!neighbors.isEmpty()) { // если у текущей ячейки есть непосещенные соседи
                var next = neighbors.get(random.nextInt(neighbors.size())); // выбираем случайного непосещенного соседа
                maze[next.x()][next.y()] = Cell.NONE; // устанавливаем выбранного соседа как пустое пространство
                maze[currentCell.x() + (next.x() - currentCell.x()) / 2][currentCell.y()
                    + (next.y() - currentCell.y()) / 2] = Cell.NONE; // устанавливаем путь между текущей и следующей
                // ячейкой как пустое пространство
                stack.push(next); // добавляем выбранного соседа в стек
            } else {
                stack.pop(); // иначе удаляем текущую ячейку из стека
            }
        }
        maze[0][1] = Cell.NONE; // установка начальной точки входа в лабиринт
        maze[width - 1][height - 2] = Cell.NONE; // установка конечной точки выхода из лабиринта

        return new Maze(height, width, new Coordinate(0, 1), new Coordinate(width - 1, height - 2), maze);
        // возвращаем созданный лабиринт
    }

    // получение списка непосещенных соседей для текущей координаты
    private ArrayList<Coordinate> getUnvisitedNeighbors(Coordinate coordinate, int height, int width) {
        var neighbors = new ArrayList<Coordinate>();

        if (coordinate.x() >= 2 && maze[coordinate.x() - 2][coordinate.y()] == Cell.WALL) {
            neighbors.add(new Coordinate(coordinate.x() - 2, coordinate.y())); // добавляем левого соседа
        }
        if (coordinate.x() < width - 2 && maze[coordinate.x() + 2][coordinate.y()] == Cell.WALL) {
            neighbors.add(new Coordinate(coordinate.x() + 2, coordinate.y())); // добавляем правого соседа
        }
        if (coordinate.y() >= 2 && maze[coordinate.x()][coordinate.y() - 2] == Cell.WALL) {
            neighbors.add(new Coordinate(coordinate.x(), coordinate.y() - 2)); // добавляем верхнего соседа
        }
        if (coordinate.y() < height - 2 && maze[coordinate.x()][coordinate.y() + 2] == Cell.WALL) {
            neighbors.add(new Coordinate(coordinate.x(), coordinate.y() + 2)); // добавляем нижнего соседа
        }

        return neighbors; // возвращаем список непосещенных соседей
    }
}
