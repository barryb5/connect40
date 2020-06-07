package com.example;

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
        height = 6;
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
        for (int w = 7; w < width; w--) {
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
        for (int h = 6; h < height; h--) {
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
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X' || board[i][j] == 'O')
                    System.out.printf("|%c|", board[i][j]);
                else
                    System.out.printf("| |");
            }
            System.out.println("\n");
        }
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
        String nextSpot = Integer.toString(nxtAvail);
        board[column][nxtAvail] = token;
        System.out.printf("%c %d %s\n", board[column][nxtAvail], column, nextSpot);
        tokensPerColumn[column] += 1;

        return tokensPerColumn[column];
    }
}
