package com.redspot;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static char[][] map;
    private static int SIZE = 3;

    private static final char DOT_EMPTY = '•';
    private static final char DOT_O = 'O';
    private static final char DOT_X = 'X';

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
	    initMap();
	    printMap();

	    while (true) {
	        humanTurn();
	        if (isEndGame(DOT_X)) {
	            break;
            }

	        computerTurn();
	        if (isEndGame(DOT_O)) {
	            break;
            }
        }
    }

    private static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + "  ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + "  ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }
    }

    private static void humanTurn() {
        int x, y;
        System.out.println("Введите корректные координаты через пробел:");
        do {
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    private static void computerTurn() {
        int x, y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellValid(x, y));
        map[y][x] = DOT_O;
        System.out.println("Противник " + DOT_O + " выбрал координаты " + (x + 1) + ", " + (y + 1));
    }

    private static boolean isCellValid(int x, int y) {
        if (x >= 0 && x < SIZE && y >= 0 && y < SIZE) {
            if (map[y][x] == DOT_EMPTY) {
                return true;
            }
        }
        return false;
    }

    private static boolean isEndGame(char playerSymbol) {
        printMap();

        if (checkWin(playerSymbol)) {
            System.out.println("Победили " + playerSymbol + "! :з");
            return true;
        }

        if (isMapFull()) {
            System.out.println("Ничья!");
            return true;
        }
        return false;
    }

    private static boolean checkWin(char player) {
        if (
                (map[0][0] == player && map[0][1] == player && map[0][2] == player) ||
                (map[1][0] == player && map[1][1] == player && map[1][2] == player) ||
                (map[2][0] == player && map[2][1] == player && map[2][2] == player) ||
                (map[0][0] == player && map[1][0] == player && map[2][0] == player) ||
                (map[0][1] == player && map[1][1] == player && map[2][1] == player) ||
                (map[0][2] == player && map[1][2] == player && map[2][2] == player) ||
                (map[0][0] == player && map[1][1] == player && map[2][2] == player) ||
                (map[0][2] == player && map[1][1] == player && map[2][0] == player)
        ) {
            return true;
        }
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}
