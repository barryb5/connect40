package com.example;
import java.time.Year;
import java.util.*;
import org.javatuples.Pair;

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
     * @param boardwidth width of board to be created
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
        int retVal[] = {-1, -1, -1, -1};
        //Horizontal Check
        for (int i = 0; i < width-3; i++) {
            for (int j = 0; j < height; j++) {
                if (board[i][j] == 'X')


                if (tokensPerColumn[i] != 0) {
                    if (CheckToken(board[i][j]) && board[i][j] == 'X') {
                        if (CheckToken(board[i + 1][j]) && board[i][j] == 'X') {
                            if (CheckToken(board[i + 2][j]) && board[i][j] == 'X') {
                                if (CheckToken(board[i + 3][j]) && board[i][j] == 'X') {
                                    retVal[0] = i;
                                    retVal[1] = j;
                                    retVal[0] = i+3;
                                    retVal[1] = j;

                                    // Debug only
                                    System.out.printf("\nX Team Wins!");
                                    return retVal;
                                }
                            }
                        }
                    } else if (CheckToken(board[i][j]) && board[i][j] == 'O') {
                        if (CheckToken(board[i + 1][j]) && board[i][j] == 'O') {
                            if (CheckToken(board[i + 2][j]) && board[i][j] == 'O') {
                                if (CheckToken(board[i + 3][j]) && board[i][j] == 'O') {
                                    System.out.printf("\nX Team Wins!");
                                }
                            }
                        }
                    } else {
                        System.out.printf("\nAn error occurred in the horizontal check, somehow the connect4 board didn't have a X or O.");
                    }
                }
            }
        }

        //Vertical Check
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (tokensPerColumn[i] != 0) {
                    if (CheckToken(board[i][j]) && board[i][j] == 'X') {
                        if (CheckToken(board[i][j + 1]) && board[i][j] == 'X') {
                            if (CheckToken(board[i][j + 2]) && board[i][j] == 'X') {
                                if (CheckToken(board[i][j + 3]) && board[i][j] == 'X') {
                                    System.out.printf("\nX Team Wins!");
                                }
                            }
                        }
                    } else if (CheckToken(board[i][j]) && board[i][j] == 'O') {
                        if (CheckToken(board[i][j + 1]) && board[i][j] == 'O') {
                            if (CheckToken(board[i][j + 2]) && board[i][j] == 'O') {
                                if (CheckToken(board[i][j + 3]) && board[i][j] == 'O') {
                                    System.out.printf("\nX Team Wins!");
                                }
                            }
                        }
                    } else {
                        System.out.printf("\nAn error occurred in the vertical check, somehow the connect4 board didn't have a X or O.");
                    }
                }
            }
        }

        return  retVal;
        //Diagonal Check
    }

    public void PrintBoard() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.printf("%c ", board[i][j]);
            }
        }
        System.out.println(" ");
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
     * @param column Column to insert
     * @param token Token 'X' or '0'
     * @return
     */
    public int AddToken(int column, char token) {
        if (token != 'X' && token != 'O')
            return -1;

        if (column > width)
            return -1;

        int nxtAvail = tokensPerColumn[column];
        if (nxtAvail >= height)
            return -1;

        board[column][nxtAvail] = token;
        tokensPerColumn[column] += 1;

        return tokensPerColumn[column];
    }

    /*
    public boolean CheckToken(char token) {
        if (token == 'X') {
            return true;
        } else if (token == 'O') {
            return true;
        } else {
            return false;
        }
    }
    **/
}
