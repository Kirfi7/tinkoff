package edu.project2;

import edu.project2.generators.GeneratorDFS;
import edu.project2.renderers.CustomRenderer;
import edu.project2.solvers.SolverAStar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
// import edu.project2.generators.RecursiveBacktrackerGenerator;

public class Main {
    private Main() {
    }

    private static final Logger LOGGER = LogManager.getLogger(); // инициализация логгера
    private static final int HEIGHT = 41; // высота лабиринта
    private static final int WIDTH = 41; // ширина лабиринта

    public static void main(String[] args) {
        var maze = new GeneratorDFS().generate(HEIGHT, WIDTH); // генерация лабиринта с помощью алгоритма DFS
        var renderer = new CustomRenderer(); // инициализация кастомного рендерера
        var path = new SolverAStar().solve(maze); // нахождение пути с помощью алгоритма A*

        LOGGER.info(renderer.render(maze)); // вывод обычного рендера лабиринта в лог
        LOGGER.info(renderer.render(maze, path)); // вывод рендера лабиринта с путем в лог
    }
}
