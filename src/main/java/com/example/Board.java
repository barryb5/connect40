package com.example;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.sql.SQLOutput;
import java.time.Year;
import java.util.*;
import java.lang.*;

public class Board {
    int width; //= 7;
    int height;// = 6;
    char[][] board;
    int[] tokensPerColumn;

    /**
     * Default Constructor
     */
    public Board() {
        width = 7;
        height = 7;
        board = new char[width][height];
        tokensPerColumn = new int[width];
    }

    /**
     * Constructor
     *
     * @param boardwidth  width of board to be created
     * @param boardheight height of board to created
     */
    public Board(int boardwidth, int boardheight) {
        width = boardwidth;
        height = boardheight;
        board = new char[width][height];
        tokensPerColumn = new int[width];
    }

    /**
     *
     */
    public int[] CheckWinner() {
        int retVal[] = {-1, -1, -1, -1, 0};
        int xNum = 0;
        int oNum = 0;

        //Horizontal Check
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                // If the value we are looking at is X, increase X counter
                if (board[i][j] == 'X') {
                    xNum++;
                    oNum = 0;
                }
                // If the value we are looking at is O, increase O counter
                else if (board[i][j] == 'O') {
                    oNum++;
                    xNum = 0;
                }
                // If there is nothing, reset both counters
                else {
                    xNum = 0;
                    oNum = 0;
                }
                if (xNum == 4) {
                    retVal[0] = i - 3;
                    retVal[1] = j;
                    retVal[2] = i;
                    retVal[3] = j;
                    retVal[4] = 1;
                    return retVal;
                }
                if (oNum == 4) {
                    retVal[0] = i - 3;
                    retVal[1] = j;
                    retVal[2] = i;
                    retVal[3] = j;
                    retVal[4] = 2;
                    return retVal;
                }
            }
        }
        //Reset Counters
        xNum = 0;
        oNum = 0;

        //Vertical Check
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (board[i][j] == 'X') {
                    xNum++;
                    oNum = 0;
                } else if (board[i][j] == 'O') {
                    oNum++;
                    xNum = 0;
                } else {
                    xNum = 0;
                    oNum = 0;
                }
                if (xNum == 4) {
                    retVal[0] = i;
                    retVal[1] = j - 3;
                    retVal[2] = i;
                    retVal[3] = j;
                    retVal[4] = 1;
                }
                if (oNum == 4) {
                    retVal[0] = i;
                    retVal[1] = j - 3;
                    retVal[2] = i;
                    retVal[3] = j;
                    retVal[4] = 2;
                    return retVal;
                }
            }
        }

        //Diagonal Check
        for (int w = 0; w < width; w++) {
            for (int i = w, j = 0; i < width && j < height; i++, j++) {
                if (board[i][j] == 'X') {
                    xNum++;
                    oNum = 0;
                } else if (board[i][j] == 'O') {
                    oNum++;
                    xNum = 0;
                } else {
                    xNum = 0;
                    oNum = 0;
                }
                if (xNum == 4) {
                    retVal[0] = i - 3;
                    retVal[1] = j - 3;
                    retVal[2] = i;
                    retVal[3] = j;
                    retVal[4] = 1;
                    return retVal;
                }
                if (oNum == 4) {
                    retVal[0] = i - 3;
                    retVal[1] = j - 3;
                    retVal[2] = i;
                    retVal[3] = j;
                    retVal[4] = 2;
                    return retVal;
                }
            }
        }
        for (int h = 0; h < height; h++) {
            for (int i = 0, j = h; i < 0 && j < height; i--, j++) {
                if (board[i][j] == 'X') {
                    xNum++;
                    oNum = 0;
                } else if (board[i][j] == 'O') {
                    oNum++;
                    xNum = 0;
                } else {
                    xNum = 0;
                    oNum = 0;
                }
                if (xNum == 4) {
                    retVal[0] = i + 3;
                    retVal[1] = j - 3;
                    retVal[2] = i;
                    retVal[3] = j;
                    retVal[4] = 1;
                    return retVal;
                }
                if (oNum == 4) {
                    retVal[0] = i + 3;
                    retVal[1] = j - 3;
                    retVal[2] = i;
                    retVal[3] = j;
                    retVal[4] = 2;
                    return retVal;
                }
            }
        }
        for (int w = width; w > 0; w--) {
            for (int i = w, j = 6; i < 0 && j < 0; i--, j--) {
                if (board[i][j] == 'X') {
                    xNum++;
                    oNum = 0;
                } else if (board[i][j] == 'O') {
                    oNum++;
                    xNum = 0;
                } else {
                    xNum = 0;
                    oNum = 0;
                }
                if (xNum == 4) {
                    retVal[0] = i + 3;
                    retVal[1] = j + 3;
                    retVal[2] = i;
                    retVal[3] = j;
                    retVal[4] = 1;
                    return retVal;
                }
                if (oNum == 4) {
                    retVal[0] = i + 3;
                    retVal[1] = j + 3;
                    retVal[2] = i;
                    retVal[3] = j;
                    retVal[4] = 2;
                    return retVal;
                }
            }
        }
        for (int h = height; h > 0; h--) {
            for (int i = 0, j = h; i < width && j < 0; i++, j--) {
                if (board[i][j] == 'X') {
                    xNum++;
                    oNum = 0;
                } else if (board[i][j] == 'O') {
                    oNum++;
                    xNum = 0;
                } else {
                    xNum = 0;
                    oNum = 0;
                }
                if (xNum == 4) {
                    retVal[0] = i - 3;
                    retVal[1] = j + 3;
                    retVal[2] = i;
                    retVal[3] = j;
                    retVal[4] = 1;
                    return retVal;
                }
                if (oNum == 4) {
                    retVal[0] = i - 3;
                    retVal[1] = j + 3;
                    retVal[2] = i;
                    retVal[3] = j;
                    retVal[4] = 2;
                    return retVal;
                }
            }
        }

        return retVal;
    }

    public void PrintBoard() {
//        //For Rotating the array -90 degrees
//        char[][] transpose = new char[height][width];
//
//        //Transpose Matrix
//        for (int i = 0; i < width; ++i) {
//            for (int j = 0; j < height; ++j) {
//                transpose[j][i] = board[i][j];
//            }
//        }
//
//        char[][] reverseCol = new char[width][height];
//        for (int i = 0; i < width; i++) {
//            for (int j = 0; j < height; j++) {
//                reverseCol[i][j] = transpose[i][j];
//            }
//        }
//
//        //Reverse Col
//        for (int i = 0; i < width; i++) {
//            char temp1 = reverseCol[i][0];
//            char temp2 = reverseCol[i][6];
//            System.out.println(temp1 + temp2);
//            reverseCol[i][0] = temp2;
//            reverseCol[i][6] = temp1;
//            temp1 = reverseCol[i][1];
//            temp2 = reverseCol[i][5];
//            reverseCol[i][1] = temp2;
//            reverseCol[i][5] = temp1;
//            temp1 = reverseCol[i][2];
//            temp2 = reverseCol[i][4];
//            reverseCol[i][2] = temp2;
//            reverseCol[i][4] = temp1;
//        }
        //Actually printing the array
        System.out.println("_______________");
        for (int x = width - 1; x > 0; --x) {
            for (int y = 0; y < height; ++y) {
                if (board[x][y] != 0) {
                    System.out.printf("%c", board[y][x]);
                }
                else {
                    System.out.printf(" ");
                }
            }
            System.out.printf("\n");
        }
        System.out.println(" 1  2  3  4  5  6  7 ");
        System.out.println("_______________");
    }

    public void ClearBoard() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                board[i][j] = 0;
            }
        }
        for (int i = 0; i < height; i++) {
            tokensPerColumn[i] = 0;
        }
    }

    /**
     * Adds a token to board
     *
     * @param column Column to insert
     * @param token  Token 'X' or '0'
     * @return
     */
    public int AddToken(int column, char token) {
        if (token != 'X' && token != 'O')
            return -1;

        if (column > width) {
            System.out.println("Put token in existing column");
            return -1;
        }

        int nxtAvail = tokensPerColumn[column];

        if (nxtAvail >= height)
            return -1;
        //String nextSpot = Integer.toString(nxtAvail);
        board[column][nxtAvail] = token;
        //System.out.printf("%c %d %s\n", board[column][nxtAvail], column, nextSpot);
        tokensPerColumn[column] += 1;

        return tokensPerColumn[column];
    }
}
