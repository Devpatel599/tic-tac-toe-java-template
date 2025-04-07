package org.example;

import java.util.Scanner;

public class Game {
    private final Scanner scanner;
    private final Board board;
    private char currentPlayer;
    private int moves;

    public Game(Scanner scanner, char startingPlayer) {
        this.scanner = scanner;
        this.board = new Board();
        this.currentPlayer = startingPlayer;
        this.moves = 0;
    }

    public char play() {
        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("Player " + currentPlayer + " will go first!");

        while (true) {
            board.print();
            int move = Utils.getValidMove(scanner, board);
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
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    }
}
