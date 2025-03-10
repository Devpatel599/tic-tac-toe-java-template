package org.example;  // Ensure this is correct

import java.util.Scanner;

public class Game {
    private final Scanner scanner;
    private final Board board;
    private char currentPlayer;
    private int moves;

    public Game(Scanner scanner) {
        this.scanner = scanner;
        this.board = new Board();
        this.currentPlayer = 'X';
        this.moves = 0;
    }

    public void play() {
        System.out.println("Welcome to Tic-Tac-Toe!");

        boolean gameOver = false;
        while (!gameOver) {
            board.print();
            int move = Utils.getValidMove(scanner, board);
            board.placeMove(move, currentPlayer);
            moves++;

            if (board.isWinner(currentPlayer)) {
                board.print();
                System.out.println("Player " + currentPlayer + " wins!");
                gameOver = true;
            } else if (moves == 9) {
                board.print();
                System.out.println("It's a draw!");
                gameOver = true;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    }
}
