package edu.hw1;

public class EighthTask {
    public static boolean knightBoardCapture(int[][] board) {
        int[][] moves = {
                {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
                {1, -2}, {1, 2}, {2, -1}, {2, 1}
        };

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 1) {
                    for (int[] move : moves) {
                        int x = i + move[0];
                        int y = j + move[1];

                        if (x >= 0 && x < rows && y >= 0 && y < cols && board[x][y] == 1) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}

