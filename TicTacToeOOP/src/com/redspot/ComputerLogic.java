package com.redspot;

import java.util.Random;

public class ComputerLogic {

    private static final int BUSY_OR_INVALID_CELL = -1;
    private static final int NOBODY_WINS = 0;
    private static final int PLAYER_WILL_WIN = 1;
    private static final int COMP_WILL_WIN = 2;

    private static final Random random = new Random();

    private static class MaxRatingCell {
        int rating;
        int x;
        int y;

        public MaxRatingCell(int rating, int x, int y) {
            this.rating = rating;
            this.x = x;
            this.y = y;
        }
    }


    public static int[] computerMove(Game game) {
        int x, y;
        GameBoard board = game.board;
        MaxRatingCell maxRatingCell = new MaxRatingCell(BUSY_OR_INVALID_CELL, -1, -1);

        do {
            x = random.nextInt(board.size);
            y = random.nextInt(board.size);
        } while (!board.isCellValid(x, y));

        int rating;

        for (int i = 0; i < board.size; i++) {
            for (int j = 0; j < board.size; j++) {
                rating = calculateRating(j, i, game);
                if (rating > maxRatingCell.rating) {
                    maxRatingCell.rating = rating;
                    maxRatingCell.x = j;
                    maxRatingCell.y = i;
                }
            }
        }

        if (maxRatingCell.rating != NOBODY_WINS) {
            x = maxRatingCell.x;
            y = maxRatingCell.y;
        }

        return new int[]{x, y};
    }

    private static int calculateRating(int x, int y, Game game) {
        int result = NOBODY_WINS;
        if (!game.board.isCellValid(x, y)) {
            result = BUSY_OR_INVALID_CELL;
        } else {
            if (isMoveWinning(x, y, game.board)) {
                result = PLAYER_WILL_WIN;
            }
            game.passTurn();
            if (isMoveWinning(x, y, game.board)) {
                result = COMP_WILL_WIN;
            }
            game.passTurn();
        }
        return result;
    }

    private static boolean isMoveWinning(int x, int y, GameBoard board) {
        boolean result = false;
        board.setCell(x, y);
        if (board.checkWin()) {
            result = true;
        }
        board.makeCellEmpty(x, y);
        return result;
    }
}
