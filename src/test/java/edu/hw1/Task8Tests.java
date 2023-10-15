package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task8Tests {

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
        assertTrue(Task8.knightBoardCapture(board));
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
        assertFalse(Task8.knightBoardCapture(board));
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
        assertFalse(Task8.knightBoardCapture(board));
    }

    @Test
    public void testKnightBoardCaptureWithEmptyBoard() {
        int[][] board = new int[8][8];
        assertTrue(Task8.knightBoardCapture(board));
    }

    @Test
    public void testKnightBoardCaptureWithSingleKnight() {
        int[][] board = new int[8][8];
        board[4][4] = 1;
        assertTrue(Task8.knightBoardCapture(board));
    }

    @Test
    public void testKnightBoardCaptureWithTwoKnightsInCapturePosition() {
        int[][] board = new int[8][8];
        board[4][4] = 1;
        board[6][5] = 1;
        assertFalse(Task8.knightBoardCapture(board));
    }

    @Test
    public void testKnightBoardCaptureWithAllKnights() {
        int[][] board = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = 1;
            }
        }
        assertFalse(Task8.knightBoardCapture(board));
    }

    @Test
    public void testKnightBoardCaptureWithOneRow() {
        int[][] board = {
            {1, 1, 0, 1, 1, 0, 0, 0}
        };
        assertTrue(Task8.knightBoardCapture(board));
    }

    @Test
    public void testKnightBoardCaptureWithOneColumn() {
        int[][] board = {
            {1},
            {1},
            {0},
            {1},
            {1},
            {0},
            {0},
            {0}
        };
        assertTrue(Task8.knightBoardCapture(board));
    }
}

