package edu.project2;

public final class Maze {
    private final int height; // высота лабиринта
    private final int width; // ширина лабиринта
    private final Cell[][] grid; // сетка лабиринта
    private final Coordinate start; // начальная координата
    private final Coordinate end; // конечная координата

    public Maze(int height, int width, Coordinate start, Coordinate end, Cell[][] grid) {
        this.height = height;
        this.width = width;
        this.start = start;
        this.end = end;
        this.grid = grid;
    }

    public Cell getCell(int x, int y) {
        return grid[x][y]; // возвращает тип ячейки по координатам
    }

    public Cell getCell(Coordinate coordinate) {
        return grid[coordinate.x()][coordinate.y()]; // возвращает тип ячейки по координатам
    }

    public int getHeight() {
        return height; // возвращает высоту лабиринта
    }

    public int getWidth() {
        return width; // возвращает ширину лабиринта
    }

    public Coordinate getStart() {
        return start; // возвращает начальную координату
    }

    public Coordinate getEnd() {
        return end; // возвращает конечную координату
    }

    public Boolean coordinateInBounds(Coordinate coordinate) {
        return coordinate.x() >= 0 && coordinate.x() < width
            && coordinate.y() >= 0 && coordinate.y() < height;
        // проверяет, находится ли координата в пределах лабиринта
    }
}
