package com.redspot;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    /** Игровое поле */
    private static char[][] map;
    private static int SIZE = 3;

    /** Графика */
    private static final char DOT_EMPTY = '•';
    private static final char DOT_O = 'O';
    private static final char DOT_X = 'X';

    /** Активация умного (ну, почти) противника */
    private static final boolean SMART_MODE = true;

    /** Константы для подсчета рейтинга клетки */
    private static final int BUSY_OR_INVALID_CELL = -1;
    private static final int NOBODY_WINS = 0;
    private static final int PLAYER_WILL_WIN = 1;
    private static final int COMP_WILL_WIN = 2;

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

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

    /**
     * Инициализация игрового поля
     */
    private static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    /**
     * Вывод игрового поля на экран
     */
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

    /**
     * Ход пользователя, обрабатывает ввод и записывает ход
     */
    private static void humanTurn() {
        int x, y;
        System.out.println("Введите корректные координаты через пробел:");
        do {
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (invalidCell(x, y));
        map[y][x] = DOT_X;
    }

    /**
     * Ход компьютера. По умолчанию генерирует случайную клетку для хода,
     * при SMART_MODE == true дополнительно высчитывается рейтинг и ищется более оптимальный ход
     * (рандомизация при этом все равно должна выполняться, иначе при отсутствии выигрышных ходов
     * компьютер будет ходить по порядку)
     * maxRatingCell - одномерный массив размером три, хранит координаты и рейтинг клетки с самым
     * высоким рейтингом по схеме {рейтинг, x, y}
     * В конце записывает ход
     */
    private static void computerTurn() {
        int x, y;

        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (invalidCell(x, y));

        if (SMART_MODE) {
            int[] maxRatingCell = new int[]{BUSY_OR_INVALID_CELL, -1, -1}; // { rating, x, y}
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (calculateRating(j, i) > maxRatingCell[0]) {
                        maxRatingCell[0] = calculateRating(j, i);
                        maxRatingCell[1] = j;
                        maxRatingCell[2] = i;
                    };
                }
            }
            if (maxRatingCell[0] != NOBODY_WINS) {
                x = maxRatingCell[1];
                y = maxRatingCell[2];
            }
        }
        map[y][x] = DOT_O;
        System.out.println("Противник " + DOT_O + " выбрал координаты " + (x + 1) + ", " + (y + 1));
    }

    /**
     * Подсчет рейтинга клетки для хода компьютера
     * @param x - координата x
     * @param y - координата y
     * @return - подсчитанный рейтинг.
     * BUSY_OR_INVALID_CELL < NOBODY_WINS < PLAYER_WILL_WIN < COMP_WILL_WIN;
     */
    private static int calculateRating(int x, int y) {
        if (invalidCell(x, y)) {
            return BUSY_OR_INVALID_CELL;
        }
        if (isMoveWinning(x, y, DOT_O)) {
            return COMP_WILL_WIN;
        } else if (isMoveWinning(x, y, DOT_X)) {
            return PLAYER_WILL_WIN;
        }
        return NOBODY_WINS;
    }

    /**
     * Метод просчитывает, будет ли ход выигрышным на этой клетке у определенного игрока
     * @param x - координата x
     * @param y - координата y
     * @param player - игрок
     * @return выигрыш - true, нет - false
     */
    private static boolean isMoveWinning(int x, int y, char player) {
        boolean result = false;
        map[y][x] = player;
        if (checkWin(player)) {
            result = true;
        }
        map[y][x] = DOT_EMPTY;
        return result;
    }

    /**
     * Проверяет координаты на корректность и пустоту
     * @param x - координата x
     * @param y - координата y
     * @return true - клетка занята/вне игрового поля. false - клетка в пределах
     * игрового поля и доступна для хода
     */
    private static boolean invalidCell(int x, int y) {
        if (x >= 0 && x < SIZE && y >= 0 && y < SIZE) {
            if (map[y][x] == DOT_EMPTY) {
                return false;
            }
        }
        return true;
    }

    /**
     * Проверяет, конец ли игры, и если да, то выводит сообщение в зависимости от исхода.
     * Дополнительно отрисовывает игровое поле после каждого хода
     * @param playerSymbol - символ игрока, который походил последним (для объявления победителя)
     * @return true - игра окончена. false - игра продолжается
     */
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

    /**
     * Проверяет победу определенного игрока
     * @param player - символ игрока
     * @return true - победа. false - нет
     */
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

    /**
     * Проверка игрового поля на свободные клетки
     * @return true - поле заполнено. false - есть свободные клетки
     */
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
