package com.example;

import java.util.*;
import java.lang.*;


public class SinglePlayerGame {
    Board board = new Board();
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    int col;

    public int ReadInput(String message) {
        System.out.printf("%s", message);
        int temp = 0;
        try {
            temp = scanner.nextInt();
            return temp;
        } catch (Exception e) {
            return -1;
        }
    }

    public void P1Turn() {
        col = 0;
        board.PrintBoard();
        col = ReadInput("Enter Column Number");
        col--;
        board.AddToken(col, 'X');
    }

    public void AITurn() {
        int rand = (random.nextInt(3) - 1);
        if (col + rand == -1 || col + rand == 8) {
            rand = 0;
        }
        board.AddToken(col + rand, 'O');
    }

    public boolean UseCheckWinner() {
        int[] winnerChecker = board.CheckWinner();
        if (winnerChecker[4] != 0) {
            if (winnerChecker[4] == 1) {
                System.out.println("Player 1 Wins!");
                return true;
            } else if (winnerChecker[4] == 2) {
                System.out.println("Player 2 Wins!");
                return true;
            } else {
                System.out.println("Fix your CheckWinner Barry");
                return false;
            }
        }
        return false;
    }

    public void Run() {
        while (true) {
            P1Turn();
            if (UseCheckWinner()) {
                board.PrintBoard();
                break;
            }
            AITurn();
            if (UseCheckWinner()) {
                board.PrintBoard();
                break;
            }
        }
    }
}
