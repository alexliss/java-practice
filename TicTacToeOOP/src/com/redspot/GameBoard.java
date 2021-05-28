package com.redspot;

import java.util.Arrays;

public class GameBoard {
    final int size = 3;
    private char[][] field;
    private final char EMPTY_CELL = '•';

    private final Game game;

    public GameBoard(Game game) {
        this.game = game;
        initField();
    }

    public void initField() {
        field = new char[size][size];
        for (int i = 0; i < field.length; i++) {
            Arrays.fill(field[i], EMPTY_CELL);
        }
    }

    public void setCell(int x, int y) {
        if (isCellValid(x, y)) {
            field[y][x] = game.getCurrentPlayer().getPlayerSign();
        }
    }

    public boolean isCellValid(int x, int y) {
        if (x >= 0 && x < size && y >= 0 && y < size) {
            if (field[y][x] == EMPTY_CELL) {
                return true;
            }
        }
        return false;
    }

    public void makeCellEmpty(int x, int y) {
        field[y][x] = EMPTY_CELL;
    }

    // святый боже...
    public boolean checkWin() {
        char playerSign = game.getCurrentPlayer().getPlayerSign();
        if (
                (field[0][0] == playerSign && field[0][1] == playerSign && field[0][2] == playerSign) ||
                        (field[1][0] == playerSign && field[1][1] == playerSign && field[1][2] == playerSign) ||
                        (field[2][0] == playerSign && field[2][1] == playerSign && field[2][2] == playerSign) ||
                        (field[0][0] == playerSign && field[1][0] == playerSign && field[2][0] == playerSign) ||
                        (field[0][1] == playerSign && field[1][1] == playerSign && field[2][1] == playerSign) ||
                        (field[0][2] == playerSign && field[1][2] == playerSign && field[2][2] == playerSign) ||
                        (field[0][0] == playerSign && field[1][1] == playerSign && field[2][2] == playerSign) ||
                        (field[0][2] == playerSign && field[1][1] == playerSign && field[2][0] == playerSign)
        ) {
            return true;
        }
        return false;
    }

    public boolean isFieldFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (field[i][j] == EMPTY_CELL) {
                    return false;
                }
            }
        }
        return true;
    }

    public char[][] getField() {
        return field;
    }

    public void printBoard() {
        for (int i = 0; i <= size; i++) {
            System.out.print(i + "  ");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print((i + 1) + "  ");
            for (int j = 0; j < size; j++) {
                System.out.print(field[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
