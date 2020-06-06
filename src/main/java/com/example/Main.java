package com.example;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalResizeListener;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
        Terminal terminal = null;

    }
}
class Board {

    int width = 7;
    int height = 6;
    char [][] board;
    int [] tokensPerColumn;

    public Board(int boardwidth, int boardheight) {
        boardwidth = 7;
        boardheight = 6;
        board = new char[boardwidth][boardheight];
        tokensPerColumn = new int[boardwidth];
    }

    public void CheckWinner() {

        //Horizontal Check
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (tokensPerColumn[i] != 0) {
                    if (CheckToken(board[i][j]) && board[i][j] == 'X') {
                        if (CheckToken(board[i + 1][j]) && board[i][j] == 'X') {
                            if (CheckToken(board[i + 2][j]) && board[i][j] == 'X') {
                                if (CheckToken(board[i + 3][j]) && board[i][j] == 'X') {
                                    System.out.printf("\nX Team Wins!");
                                }
                            }
                        }
                    }
                    else if (CheckToken(board[i][j]) && board[i][j] == 'O') {
                        if (CheckToken(board[i + 1][j]) && board[i][j] == 'O') {
                            if (CheckToken(board[i + 2][j]) && board[i][j] == 'O') {
                                if (CheckToken(board[i + 3][j]) && board[i][j] == 'O') {
                                    System.out.printf("\nX Team Wins!");
                                }
                            }
                        }
                    }
                    else {
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
                    }
                    else if (CheckToken(board[i][j]) && board[i][j] == 'O') {
                        if (CheckToken(board[i][j + 1]) && board[i][j] == 'O') {
                            if (CheckToken(board[i][j + 2]) && board[i][j] == 'O') {
                                if (CheckToken(board[i][j + 3]) && board[i][j] == 'O') {
                                    System.out.printf("\nX Team Wins!");
                                }
                            }
                        }
                    }
                    else {
                        System.out.printf("\nAn error occurred in the vertical check, somehow the connect4 board didn't have a X or O.");
                    }
                }
            }
        }

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

    public void AddToken(int column, char token) {
        int emptyRow = tokensPerColumn[column];
        board[column][emptyRow] = token;
        tokensPerColumn[column] += 1;
    }

    public boolean CheckToken(char token)
    {
        if (token == 'X') {
            return true;
        }
        else if (token == 'O') {
            return true;
        }
        else {
            return false;
        }
    }

}
