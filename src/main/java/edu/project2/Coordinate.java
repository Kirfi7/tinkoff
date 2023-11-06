package edu.project2;

public record Coordinate(int x, int y) {
    public Coordinate plus(Coordinate other) {
        return new Coordinate(this.x + other.x, this.y + other.y); // метод для сложения координат
    }

    public double calculateDistance(Coordinate other) {
        return Math.sqrt(Math.pow((this.x() - other.x()), 2.0) + Math.pow((this.y() - other.y()), 2.0));
        // метод для вычисления расстояния между координатами
    }
}
