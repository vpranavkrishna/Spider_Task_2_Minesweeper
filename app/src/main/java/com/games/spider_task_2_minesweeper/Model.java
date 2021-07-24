package com.games.spider_task_2_minesweeper;
import java.util.Random;

public class Model {
    public static int difficulty;
    public static final int MINE = -1;
    public static int [][] model  ;
    public static boolean[][] sense;

    public static void setminesboard() {
        Random r = new Random();
        for (int i = 0; i < difficulty; i++) {
            int x = r.nextInt(8);
            int y = r.nextInt(8);
            while (model[x][y] == MINE) {
                x = r.nextInt(8);
                y = r.nextInt(8);
            }
            model[x][y] = MINE;
        }
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 7; j++) {
                if (model[i][j] != MINE) {
                    int count = 0;
                    if (model[i - 1][j] == MINE) {
                        count++;
                    }

                    if (model[i - 1][j + 1] == MINE) {
                        count++;
                    }

                    if (model[i - 1][j - 1] == MINE) {
                        count++;
                    }

                    if (model[i][j - 1] == MINE) {
                        count++;
                    }

                    if (model[i][j + 1] == MINE) {
                        count++;
                    }

                    if (model[i + 1][j - 1] == MINE) {
                        count++;
                    }

                    if (model[i + 1][j] == MINE) {
                        count++;
                    }

                    if (model[i + 1][j + 1] == MINE) {
                        count++;
                    }

                    model[i][j] = count;
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 1; j++) {
                if (model[i][j] != MINE) {
                    int count = 0;
                    if (i == 0 && j == 0) {
                        if (model[1][1] == MINE)
                            count++;
                        if (model[1][0] == MINE)
                            count++;
                        if (model[0][1] == MINE)
                            count++;
                        model[i][j] = count;
                    }
                    if (i == 1 && j == 0) {
                        if (model[0][0] == MINE)
                            count++;
                        if (model[0][1] == MINE)
                            count++;
                        if (model[1][1] == MINE)
                            count++;
                        if (model[2][0] == MINE)
                            count++;
                        if (model[2][1] == MINE)
                            count++;
                        model[i][j] = count;
                    }
                    if (i == 2 && j == 0) {
                        if (model[1][0] == MINE)
                            count++;
                        if (model[1][1] == MINE)
                            count++;
                        if (model[2][1] == MINE)
                            count++;
                        if (model[3][0] == MINE)
                            count++;
                        if (model[3][1] == MINE)
                            count++;
                        model[i][j] = count;
                    }
                    if (i == 3 && j == 0) {
                        if (model[2][0] == MINE)
                            count++;
                        if (model[2][1] == MINE)
                            count++;
                        if (model[3][1] == MINE)
                            count++;
                        if (model[4][0] == MINE)
                            count++;
                        if (model[4][1] == MINE)
                            count++;
                        model[i][j] = count;
                    }
                    if (i == 4 && j == 0) {
                        if (model[3][0] == MINE)
                            count++;
                        if (model[3][1] == MINE)
                            count++;
                        if (model[4][1] == MINE)
                            count++;
                        if (model[5][0] == MINE)
                            count++;
                        if (model[5][1] == MINE)
                            count++;
                        model[i][j] = count;
                    }
                    if (i == 5 && j == 0) {
                        if (model[4][0] == MINE)
                            count++;
                        if (model[4][1] == MINE)
                            count++;
                        if (model[5][1] == MINE)
                            count++;
                        if (model[6][0] == MINE)
                            count++;
                        if (model[6][1] == MINE)
                            count++;
                        model[i][j] = count;
                    }
                    if (i == 6 && j == 0) {
                        if (model[5][0] == MINE)
                            count++;
                        if (model[5][1] == MINE)
                            count++;
                        if (model[6][1] == MINE)
                            count++;
                        if (model[7][0] == MINE)
                            count++;
                        if (model[7][1] == MINE)
                            count++;
                        model[i][j] = count;
                    }
                    if (i == 7 && j == 0) {
                        if (model[6][0] == MINE)
                            count++;
                        if (model[6][1] == MINE)
                            count++;
                        if (model[7][1] == MINE)
                            count++;
                        model[i][j] = count;
                    }
                }
            }
        }
        for (int i = 0; i < 1; i++) {
            for (int j = 1; j < 8; j++) {
                if (model[i][j] != MINE) {
                    int count = 0;
                    if (i == 0 && j == 1) {
                        if (model[0][0] == MINE)
                            count++;
                        if (model[0][2] == MINE)
                            count++;
                        if (model[1][0] == MINE)
                            count++;
                        if (model[1][1] == MINE)
                            count++;
                        if (model[1][2] == MINE)
                            count++;
                        model[i][j] = count;
                    }
                    if (i == 0 && j == 2) {
                        if (model[0][1] == MINE)
                            count++;
                        if (model[0][3] == MINE)
                            count++;
                        if (model[1][1] == MINE)
                            count++;
                        if (model[1][2] == MINE)
                            count++;
                        if (model[1][3] == MINE)
                            count++;
                        model[i][j] = count;
                    }
                    if (i == 0 && j == 3) {
                        if (model[0][2] == MINE)
                            count++;
                        if (model[0][4] == MINE)
                            count++;
                        if (model[1][2] == MINE)
                            count++;
                        if (model[1][3] == MINE)
                            count++;
                        if (model[1][4] == MINE)
                            count++;
                        model[i][j] = count;
                    }
                    if (i == 0 && j == 4) {
                        if (model[0][3] == MINE)
                            count++;
                        if (model[0][5] == MINE)
                            count++;
                        if (model[1][3] == MINE)
                            count++;
                        if (model[1][4] == MINE)
                            count++;
                        if (model[1][5] == MINE)
                            count++;
                        model[i][j] = count;
                    }
                    if (i == 0 && j == 5) {
                        if (model[0][4] == MINE)
                            count++;
                        if (model[0][6] == MINE)
                            count++;
                        if (model[1][4] == MINE)
                            count++;
                        if (model[1][5] == MINE)
                            count++;
                        if (model[1][6] == MINE)
                            count++;
                        model[i][j] = count;
                    }
                    if (i == 0 && j == 6) {
                        if (model[0][5] == MINE)
                            count++;
                        if (model[0][7] == MINE)
                            count++;
                        if (model[1][5] == MINE)
                            count++;
                        if (model[1][6] == MINE)
                            count++;
                        if (model[1][7] == MINE)
                            count++;
                        model[i][j] = count;
                    }
                    if (i == 0 && j == 7) {
                        if (model[0][6] == MINE)
                            count++;
                        if (model[1][6] == MINE)
                            count++;
                        if (model[1][7] == MINE)
                            count++;
                        model[i][j] = count;
                    }
                }

            }
        }
        for (int i = 1; i < 8; i++) {
            for (int j = 7; j < 8; j++) {
                if (model[i][j] != MINE) {
                    int count = 0;
                    if (i == 1 && j == 7) {
                        if (model[0][7] == MINE)
                            count++;
                        if (model[1][6] == MINE)
                            count++;
                        if (model[0][6] == MINE)
                            count++;
                        if (model[2][6] == MINE)
                            count++;
                        model[i][j] = count;
                    }
                    if (i == 2 && j == 7) {
                        if (model[1][7] == MINE)
                            count++;
                        if (model[1][6] == MINE)
                            count++;
                        if (model[2][6] == MINE)
                            count++;
                        if (model[3][6] == MINE)
                            count++;
                        if (model[3][7] == MINE)
                            count++;
                        model[i][j] = count;
                    }
                    if (i == 3 && j == 7) {
                        if (model[2][7] == MINE)
                            count++;
                        if (model[2][6] == MINE)
                            count++;
                        if (model[3][6] == MINE)
                            count++;
                        if (model[4][6] == MINE)
                            count++;
                        if (model[4][7] == MINE)
                            count++;
                        model[i][j] = count;
                    }
                    if (i == 4 && j == 7) {
                        if (model[3][7] == MINE)
                            count++;
                        if (model[3][6] == MINE)
                            count++;
                        if (model[4][6] == MINE)
                            count++;
                        if (model[5][6] == MINE)
                            count++;
                        if (model[5][7] == MINE)
                            count++;
                        model[i][j] = count;
                    }
                    if (i == 5 && j == 7) {
                        if (model[4][7] == MINE)
                            count++;
                        if (model[4][6] == MINE)
                            count++;
                        if (model[5][6] == MINE)
                            count++;
                        if (model[6][6] == MINE)
                            count++;
                        if (model[6][7] == MINE)
                            count++;
                        model[i][j] = count;
                    }
                    if (i == 6 && j == 7) {
                        if (model[5][7] == MINE)
                            count++;
                        if (model[5][6] == MINE)
                            count++;
                        if (model[6][6] == MINE)
                            count++;
                        if (model[7][6] == MINE)
                            count++;
                        if (model[7][7] == MINE)
                            count++;
                        model[i][j] = count;
                    }
                    if (i == 7 && j == 7) {
                        if (model[6][7] == MINE)
                            count++;
                        if (model[6][6] == MINE)
                            count++;
                        if (model[7][6] == MINE)
                            count++;
                        model[i][j] = count;
                    }
                }

            }
        }
        for (int i = 7; i < 8; i++) {
            for (int j = 1; j < 7; j++) {
                if (model[i][j] != MINE) {
                    int count = 0;
                    if (i == 7 && j == 1) {
                        if (model[7][0] == MINE)
                            count++;
                        if (model[6][0] == MINE)
                            count++;
                        if (model[6][1] == MINE)
                            count++;
                        if (model[6][2] == MINE)
                            count++;
                        if (model[7][2] == MINE)
                            count++;
                        model[i][j] = count;
                    }
                    if (i == 7 && j == 2) {
                        if (model[7][1] == MINE)
                            count++;
                        if (model[6][1] == MINE)
                            count++;
                        if (model[6][2] == MINE)
                            count++;
                        if (model[6][3] == MINE)
                            count++;
                        if (model[7][3] == MINE)
                            count++;
                        model[i][j] = count;
                    }
                    if (i == 7 && j == 3) {
                        if (model[7][2] == MINE)
                            count++;
                        if (model[6][2] == MINE)
                            count++;
                        if (model[6][3] == MINE)
                            count++;
                        if (model[6][4] == MINE)
                            count++;
                        if (model[7][4] == MINE)
                            count++;
                        model[i][j] = count;
                    }
                    if (i == 7 && j == 4) {
                        if (model[7][3] == MINE)
                            count++;
                        if (model[6][3] == MINE)
                            count++;
                        if (model[6][4] == MINE)
                            count++;
                        if (model[6][5] == MINE)
                            count++;
                        if (model[7][5] == MINE)
                            count++;
                        model[i][j] = count;
                    }
                    if (i == 7 && j == 5) {
                        if (model[7][4] == MINE)
                            count++;
                        if (model[6][4] == MINE)
                            count++;
                        if (model[6][5] == MINE)
                            count++;
                        if (model[6][6] == MINE)
                            count++;
                        if (model[7][6] == MINE)
                            count++;
                        model[i][j] = count;
                    }
                    if (i == 7 && j == 6) {
                        if (model[7][5] == MINE)
                            count++;
                        if (model[6][5] == MINE)
                            count++;
                        if (model[6][6] == MINE)
                            count++;
                        if (model[6][7] == MINE)
                            count++;
                        if (model[7][7] == MINE)
                            count++;
                        model[i][j] = count;
                    }
                }
            }

        }
    }
        public static void drawmodel()
        {
            model = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}};
            //To sence whether the cell is touched or not
            sense = new boolean[][]{{false, false, false, false, false, false, false, false}, {false, false, false, false, false, false, false, false}, {false, false, false, false, false, false, false, false}, {false, false, false, false, false, false, false, false},
                    {false, false, false, false, false, false, false, false}, {false, false, false, false, false, false, false, false}, {false, false, false, false, false, false, false, false}, {false, false, false, false, false, false, false, false}};

        }

}
