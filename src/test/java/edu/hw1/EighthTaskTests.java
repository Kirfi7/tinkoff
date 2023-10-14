package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EighthTaskTests {

    @Test
    public void testKnightBoardCaptureWithNoCaptures() {
        int[][] board = {
                {0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0}
        };
        assertTrue(EighthTask.knightBoardCapture(board));
    }

    @Test
    public void testKnightBoardCaptureWithCaptures() {
        int[][] board = {
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 1, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 1}
        };
        assertFalse(EighthTask.knightBoardCapture(board));
    }

    @Test
    public void testKnightBoardCaptureWithPartialCaptures() {
        int[][] board = {
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };
        assertFalse(EighthTask.knightBoardCapture(board));
    }

    @Test
    public void testKnightBoardCaptureWithEmptyBoard() {
        int[][] board = new int[8][8];
        assertTrue(EighthTask.knightBoardCapture(board));
    }

    @Test
    public void testKnightBoardCaptureWithSingleKnight() {
        int[][] board = new int[8][8];
        board[4][4] = 1;
        assertTrue(EighthTask.knightBoardCapture(board));
    }

    @Test
    public void testKnightBoardCaptureWithTwoKnightsInCapturePosition() {
        int[][] board = new int[8][8];
        board[4][4] = 1;
        board[6][5] = 1;
        assertFalse(EighthTask.knightBoardCapture(board));
    }
}

