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

        Board b = new Board();
        b.AddToken(3, 'X');
        b.AddToken(4, 'X');
        b.AddToken(5, 'X');
        b.AddToken(6, 'X');

        b.AddToken(2, '0');
        b.AddToken(3, '0');
        b.AddToken(4, '0');

        b.PrintBoard();



//        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
//       Terminal terminal = null;

    }
}
