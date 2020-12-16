package GeekBrains.Level1.Lesson8.Homework;

import java.util.Random;

public class Logic {
    static int SIZE;
    static int STEP;

    static boolean FLAGTOBLOCK = false;
    static int XTOBLOCK;
    static int YTOBLOCK;

    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';
    static int LASTX;
    static int LASTY;

    static String WHO_WIN;

    static char[][] map;

    static Random random = new Random();

    static boolean gameFinished;

    public static void go() {
        gameFinished = true;

        printMap();
        if (checkWin(LASTX, LASTY, DOT_X)) {
            WHO_WIN = "Вы выиграли!!!";
            return;
        }
        if (isFull()) {
            WHO_WIN = "Ничья";
            return;
        }

        aiTurn();
        printMap();
        if (checkWin(LASTX, LASTY, DOT_O)) {
            WHO_WIN = "Комьютер победил";
            return;
        }
        if (isFull()) {
            WHO_WIN = "Ничья";
            return;
        }

        gameFinished = false;
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

    static void humanTurn(int x, int y) {
        if (isCellValid(y, x)) {
            map[y][x] = DOT_X;
            LASTX = x;
            LASTY = y;
            go();
        }
    }

    static void aiTurn() {
        int x;
        int y;
        if(FLAGTOBLOCK && map[YTOBLOCK][XTOBLOCK] == DOT_EMPTY) {
            map[YTOBLOCK][XTOBLOCK] = DOT_O;
            LASTX = XTOBLOCK;
            LASTY = YTOBLOCK;
        } else {
            FLAGTOBLOCK = false;
            checkWin(XTOBLOCK, YTOBLOCK, DOT_X);
            if (FLAGTOBLOCK) {
                map[YTOBLOCK][XTOBLOCK] = DOT_O;
                LASTX = XTOBLOCK;
                LASTY = YTOBLOCK;
            } else {
                do {
                    x = random.nextInt(SIZE);
                    y = random.nextInt(SIZE);
                } while (!isCellValid(y, x));
                map[y][x] = DOT_O;
                LASTX = x;
                LASTY = y;
            }
        }
        FLAGTOBLOCK = false;
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
        int count;
        int countInBothSide;

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
                    if(map[y][xStart + j] == c) {
                        count++;
                        if(j == sizeOfMetods[i] - 1 && count == STEP - 1 && !FLAGTOBLOCK) {
                            FLAGTOBLOCK = true;
                            XTOBLOCK = SIZE - STEP;
                            YTOBLOCK = y;
                        }
                    } else {
                        countInBothSide = 0;
                        if(map[y][xStart + j] == DOT_EMPTY && !FLAGTOBLOCK) {
                            int k = 1;
                            while(j - k >= 0 && map[y][xStart + j - k] == c) {
                                countInBothSide++;
                                k++;
                            }
                            k = 1;
                            while(j + k <= sizeOfMetods[i] - 1 && map[y][xStart + j + k] == c) {
                                countInBothSide++;
                                k++;
                            }
                        }
                        if(countInBothSide == STEP - 1) {
                            FLAGTOBLOCK = true;
                            XTOBLOCK = xStart + j;
                            YTOBLOCK = y;
                        }
                        count = 0;
                    }
                }
                if(i == 1) {
                    if(map[yStart + j][x] == c) {
                        count++;
                        if(j == sizeOfMetods[i] - 1 && count == STEP - 1 && !FLAGTOBLOCK) {
                            FLAGTOBLOCK = true;
                            XTOBLOCK = x;
                            YTOBLOCK = SIZE - STEP;
                        }
                    } else {
                        countInBothSide = 0;
                        if(map[yStart + j][x] == DOT_EMPTY && !FLAGTOBLOCK) {
                            int k = 1;
                            while(j - k >= 0 && map[yStart + j - k][x] == c) {
                                countInBothSide++;
                                k++;
                            }
                            k = 1;
                            while(j + k <= sizeOfMetods[i] - 1 && map[yStart + j + k][x] == c) {
                                countInBothSide++;
                                k++;
                            }
                        }
                        if(countInBothSide == STEP - 1) {
                            FLAGTOBLOCK = true;
                            XTOBLOCK = x;
                            YTOBLOCK = yStart + j;
                        }
                        count = 0;
                    }
                }
                if(i == 2) {
                    if(map[diagonal1StartY + j][diagonal1StartX + j] == c) {
                        count++;
                        if(j == sizeOfMetods[i] - 1 && count == STEP - 1 && !FLAGTOBLOCK) {
                            FLAGTOBLOCK = true;
                            XTOBLOCK = SIZE - STEP;
                            YTOBLOCK = SIZE - STEP;
                        }
                    } else {
                        countInBothSide = 0;
                        if(map[diagonal1StartY + j][diagonal1StartX + j] == DOT_EMPTY && !FLAGTOBLOCK) {
                            int k = 1;
                            while(j - k >= 0 && map[diagonal1StartY + j - k][diagonal1StartX + j - k] == c) {
                                countInBothSide++;
                                k++;
                            }
                            k = 1;
                            while(j + k <= sizeOfMetods[i] - 1 && map[diagonal1StartY + j + k][diagonal1StartX + j + k] == c) {
                                countInBothSide++;
                                k++;
                            }
                        }
                        if(countInBothSide == STEP - 1) {
                            FLAGTOBLOCK = true;
                            XTOBLOCK = diagonal1StartX + j;
                            YTOBLOCK = diagonal1StartY + j;
                        }
                        count = 0;
                    }
                }
                if(i == 3) {
                    if(map[diagonal2StartY + j][diagonal2StartX - j] == c) {
                        count++;
                        if(j == sizeOfMetods[i] - 1 && count == STEP - 1 && !FLAGTOBLOCK) {
                            FLAGTOBLOCK = true;
                            XTOBLOCK = SIZE - STEP;
                            YTOBLOCK = SIZE - STEP;
                        }
                    } else {
                        countInBothSide = 0;
                        if(map[diagonal2StartY + j][diagonal2StartX - j] == DOT_EMPTY && !FLAGTOBLOCK) {
                            int k = 1;
                            while(j - k >= 0 && map[diagonal2StartY + j - k][diagonal2StartX - j + k] == c) {
                                countInBothSide++;
                                k++;
                            }
                            k = 1;
                            while(j + k <= sizeOfMetods[i] - 1 && map[diagonal2StartY + j + k][diagonal2StartX - j - k] == c) {
                                countInBothSide++;
                                k++;
                            }
                        }
                        if(countInBothSide == STEP - 1) {
                            FLAGTOBLOCK = true;
                            XTOBLOCK = diagonal2StartX - j;
                            YTOBLOCK = diagonal2StartY + j;
                        }
                        count = 0;
                    }
                }
                if(count == STEP) {
                    return true;
                }
            }
        }
        return false;
    }
}