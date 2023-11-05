package edu.project2.generators;

import edu.project2.Maze;

public interface Generator {
    // Интерфейс, определяющий методы для генерации лабиринта
    Maze generate(int height, int width);
}
