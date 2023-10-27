package edu.hw1;

public class Task8 {

    // константа для задания ходов коня
    private static final int CONFIG_VALUE = -2;

    private Task8() {
        // приватный конструктор
    }

    // Проверяет, может ли шахматный конь захватить другую фигуру на доске.
    public static boolean knightBoardCapture(int[][] board) {
        // возможные ходы для коня
        int[][] moves = {
            {CONFIG_VALUE, -1}, {CONFIG_VALUE, 1}, {-1, CONFIG_VALUE}, {-1, 2},
            {1, CONFIG_VALUE}, {1, 2}, {2, -1}, {2, 1}
        };

        // количество строк на доске
        int rows = board.length;
        // количество столбцов на доске
        int cols = board[0].length;

        // перебираем каждую ячейку на доске
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 1) {
                    // проверяем все возможные ходы коня
                    for (int[] move : moves) {
                        // координаты новой позиции после хода
                        int x = i + move[0];
                        int y = j + move[1];

                        // если новая позиция находится на доске
                        if (x >= 0 && x < rows && y >= 0 && y < cols && board[x][y] == 1) {
                            // если конь может захватить фигуру, возвращаем false
                            return false;
                        }
                    }
                }
            }
        }

        // если ни одна фигура не может быть захвачена, возвращаем true
        return true;
    }
}

