package GeekBrains.Lesson4.Homework;

import java.util.Random;
import java.util.Scanner;

public class Task4 {
    static final int SIZE = 3;
    static final int STEP = 3;

    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';
    static int LASTX;
    static int LASTY;

    static char[][] map;

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();


    public static void main(String[] args) {
        initMap();
        printMap();

        while (true) {
            humanTurn();
            printMap();
            if (checkWin(LASTX, LASTY, DOT_X)) {
                System.out.println("Вы выиграли!!!");
                break;
            }
            if (isFull()) {
                System.out.println("Ничья");
                break;
            }

            aiTurn();
            printMap();
            if (checkWin(LASTX, LASTY, DOT_O)) {
                System.out.println("Комьютер победил");
                break;
            }
            if (isFull()) {
                System.out.println("Ничья");
                break;
            }
        }
    }

    static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    static void printMap() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%c ", map[i][j]);
            }
            System.out.println();
        }
    }

    static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("input coord X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(y, x));
        map[y][x] = DOT_X;
        LASTX = x;
        LASTY = y;
    }

    static void aiTurn() {
        int x;
        int y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellValid(y, x));
        map[y][x] = DOT_O;
        LASTX = x;
        LASTY = y;
    }


    static boolean isCellValid(int y, int x) {
        if (y < 0 || x < 0 || y >= SIZE || x >= SIZE) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }

    static boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean checkWin(int x, int y, char c) {

        int xStart = 0, yStart = 0, xEnd = SIZE - 1, yEnd = SIZE - 1;
        int[] sizeOfMetods = new int[4];
        int count = 0;

        if(x - STEP >= 0) {
            xStart = x - STEP + 1;
        }
        if(y - STEP >= 0) {
            yStart = y - STEP + 1;
        }
        if(x + STEP <= SIZE) {
            xEnd = x + STEP - 1;
        }
        if(y + STEP <= SIZE) {
            yEnd = y + STEP - 1;
        }

        int diagonal1StartX = xStart, diagonal1StartY = yStart, diagonal1EndX = xEnd, diagonal1EndY = yEnd;
        int diagonal2StartX = xEnd, diagonal2StartY = yStart, diagonal2EndX = xStart, diagonal2EndY = yEnd;

        if(x - xStart >= y - yStart) {
            diagonal1StartX = x - (y - yStart);
        } else {
            diagonal1StartY = y - (x - xStart);
        }

        if(xEnd - x >= yEnd - y) {
            diagonal1EndX = x + (yEnd - y);
        } else {
            diagonal1EndY = y + (xEnd - x);
        }

        if(xEnd - x >= y - yStart) {
            diagonal2StartX = x + (y - yStart);
        } else {
            diagonal2StartY = y - (xEnd - x);
        }

        if(x - xStart >= yEnd - y) {
            diagonal2EndX = x - (yEnd - y);
        } else {
            diagonal2EndY = y + (x - xStart);
        }

        sizeOfMetods[0] = xEnd - xStart + 1;
        sizeOfMetods[1] = yEnd - yStart + 1;
        sizeOfMetods[2] = diagonal1EndX - diagonal1StartX + 1;
        sizeOfMetods[3] = diagonal2EndY - diagonal2StartY + 1;

        for (int i = 0; i < 4; i++) {
            count = 0;
            for (int j = 0; j < sizeOfMetods[i]; j++) {
                if(i == 0) {
                    if(map[xStart + j][y] == c) {
                        count++;
                    } else {
                        count = 0;
                    }
                }
                if(i == 1) {
                    if(map[yStart + j][x] == c) {
                        count++;
                    } else {
                        count = 0;
                    }
                }
                if(i == 2) {
                    if(map[diagonal1StartX + j][diagonal1StartY + j] == c) {
                        count++;
                    } else {
                        count = 0;
                    }
                }
                if(i == 3) {
                    if(map[diagonal2StartX - j][diagonal2StartY + j] == c) {
                        count++;
                    } else {
                        count = 0;
                    }
                }
//                System.out.println(count);
                if(count == STEP) {
                    return true;
                }
            }
        }
        return false;
    }
}
