package com.example;

import java.util.*;
import java.lang.*;


public class SinglePlayerGame {
    Board board = new Board();
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

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

    public void Round() {
        board.PrintBoard();
        int col = ReadInput("Enter Column Number");
        board.AddToken(col, 'X');

        int rand = (random.nextInt(3) - 1);
        board.AddToken(col + rand, 'O');
    }

    public void Run() {
        while (true) {
            Round();

            int[] winnerChecker = board.CheckWinner();

            if (winnerChecker[0] != winnerChecker[2] && winnerChecker[1] != winnerChecker[3]) {
                if (winnerChecker[4] == 1) {
                    System.out.println("Player 1 Wins!");
                    break;
                }
                else if (winnerChecker[4] == 2) {
                    System.out.println("Player 2 Wins!");
                    break;
                }
                else {
                    System.out.println("Fix your CheckWinner Barry");
                    break;
                }
            }
        }
    }
}