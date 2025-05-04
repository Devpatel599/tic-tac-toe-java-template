package org.example;

import java.util.Scanner;

public class Game {
    private final Scanner scanner;
    private final Board board;
    private final int mode;
    private char currentPlayer;
    private int moves;
    private final ComputerPlayer ai;

    public Game(Scanner scanner, int mode) {
        this.scanner = scanner;
        this.board = new Board();
        this.mode = mode;
        this.currentPlayer = 'X';
        this.moves = 0;
        this.ai = new ComputerPlayer();
    }

    public char play() {
        System.out.println((mode == 3 ? "Computer" : "Player X") + " will go first!");

        while (true) {
            board.print();

            int move;
            if ((mode == 2 && currentPlayer == 'O') || (mode == 3 && currentPlayer == 'X')) {
                move = ai.chooseMove(board, currentPlayer, (currentPlayer == 'X' ? 'O' : 'X'), moves);
                System.out.println("Computer chooses: " + move);
            } else {
                move = Utils.getValidMove(scanner, board);
            }

            board.placeMove(move, currentPlayer);
            moves++;

            if (board.isWinner(currentPlayer)) {
                board.print();
                System.out.println("Player " + currentPlayer + " wins!");
                return currentPlayer;
            } else if (moves == 9) {
                board.print();
                System.out.println("It's a draw!");
                return 'T';
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }
}
