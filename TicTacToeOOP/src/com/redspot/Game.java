package com.redspot;

import java.util.Scanner;
import com.redspot.ComputerLogic;

public class Game {
    GameBoard board;  // игровое поле
    GamePlayer[] players = new GamePlayer[2];  // массив игроков
    int playersTurn = 0;  // индекс текущего игрока

    private static final Scanner scanner = new Scanner(System.in);

    public Game() {
        board = new GameBoard(this);
        players[0] = new GamePlayer('X', true);
        players[1] = new GamePlayer('O', false);
    }

    public void start() { // инициация игры
        board.printBoard();
        while (true) {
            turn();
            if (isEndGame()) {
                break;
            }
            passTurn();
        }
    }

    public void turn() {
        int[] xy;

        if (players[playersTurn].isRealPlayer()) {
            xy = playerMove();
        } else {
            xy = ComputerLogic.computerMove(this);
        }
        board.setCell(xy[0], xy[1]);

        System.out.println("Игрок " + players[playersTurn].getPlayerSign() + ": " + (xy[0] + 1) + ", " + (xy[1] + 1) + "\n");
    }

    public boolean isEndGame() {
        board.printBoard();

        if (board.checkWin()) {
            System.out.println("Победили " + getCurrentPlayer().getPlayerSign() + "! :з");
            return true;
        }

        if (board.isFieldFull()) {
            System.out.println("Ничья!");
            return true;
        }
        return false;
    }

    public void passTurn() {  // передача хода
        if (playersTurn == 0) {
            playersTurn = 1;
        } else {
            playersTurn = 0;
        }
    }

    public GamePlayer getCurrentPlayer() {  // получение текущего игрока
        return players[playersTurn];
    }

    public int[] playerMove() {
        int x, y;
        System.out.println("Введите корректные координаты через пробел:");
        do {
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!board.isCellValid(x, y));
        return new int[]{x, y};
    }
}
