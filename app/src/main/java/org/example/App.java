package org.example;

import java.util.Scanner;

public class App {
    /**
     * This method returns a greeting. It is used by AppTest.java to ensure the greeting
     * isn't null.
     */
    public String getGreeting() {
        return "Hello World!";
    }

    /**
     * Main entry point: runs the Tic-Tac-Toe game logic.
     */
    public static void main(String[] args) {
        App app = new App();
        app.runTicTacToe();
    }

    /**
     * Orchestrates the main flow of the game:
     *  - keep prompting the user to play again if they choose.
     */
    public void runTicTacToe() {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            playSingleGame(scanner);
            playAgain = promptPlayAgain(scanner);
        } while (playAgain);

        System.out.println("Goodbye!");
        scanner.close();
    }

    /**
     * Plays a single round of Tic-Tac-Toe (one 3x3 board).
     */
    private void playSingleGame(Scanner scanner) {
        // Display a welcome message
        System.out.println("Welcome to Tic-Tac-Toe!");
        // Initialize the board with positions 1-9
        char[] board = initializeBoard();

        char currentPlayer = 'X';
        int moves = 0;
        boolean gameOver = false;

        // Keep playing until there's a winner or the board is full
        while (!gameOver) {
            printBoard(board);
            int move = getValidMove(scanner, board, currentPlayer);
            // Place the player's move
            board[move - 1] = currentPlayer;
            moves++;

            // Check for a winner
            if (isWinner(board, currentPlayer)) {
                printBoard(board);
                System.out.println("Player " + currentPlayer + " wins!");
                gameOver = true;
            }
            // Check for a draw
            else if (moves == 9) {
                printBoard(board);
                System.out.println("It's a draw!");
                gameOver = true;
            }
            else {
                // Switch to the other player
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    }

    /**
     * Prompts the user if they want to play again and returns true/false.
     */
    private boolean promptPlayAgain(Scanner scanner) {
        while (true) {
            System.out.print("Would you like to play again (yes/no)? ");
            String answer = scanner.nextLine().trim();

            if (answer.equalsIgnoreCase("yes")) {
                return true;
            } else if (answer.equalsIgnoreCase("no")) {
                return false;
            } else {
                System.out.println("That is not a valid entry!");
            }
        }
    }

    /**
     * Initializes a 3x3 board labeled '1' through '9'.
     */
    private char[] initializeBoard() {
        char[] board = new char[9];
        for (int i = 0; i < 9; i++) {
            // Convert (i+1) into a character (e.g., 1 -> '1')
            board[i] = (char) ('1' + i);
        }
        return board;
    }

    /**
     * Prints the current state of the board to the console.
     */
    private void printBoard(char[] board) {
        System.out.println();
        System.out.println("   " + board[0] + "  |  " + board[1] + "  |  " + board[2]);
        System.out.println("  -----+-----+-----");
        System.out.println("   " + board[3] + "  |  " + board[4] + "  |  " + board[5]);
        System.out.println("  -----+-----+-----");
        System.out.println("   " + board[6] + "  |  " + board[7] + "  |  " + board[8]);
        System.out.println();
    }

    /**
     * Prompts the user for a valid move (1-9) and ensures that:
     *  - The input is a number
     *  - The number is between 1 and 9
     *  - That position on the board is not already taken by 'X' or 'O'
     */
    private int getValidMove(Scanner scanner, char[] board, char currentPlayer) {
        while (true) {
            System.out.print("What is your move? ");
            String input = scanner.nextLine().trim();

            // Attempt to parse the input as an integer
            try {
                int move = Integer.parseInt(input);
                // Check bounds
                if (move < 1 || move > 9) {
                    System.out.println("That is not a valid move! Try again.");
                } 
                // Check if cell is already taken
                else if (board[move - 1] == 'X' || board[move - 1] == 'O') {
                    System.out.println("That is not a valid move! Try again.");
                } 
                else {
                    return move;
                }
            } catch (NumberFormatException e) {
                System.out.println("That is not a valid move! Try again.");
            }
        }
    }

    /**
     * Checks if the current player has a winning configuration.
     */
    private boolean isWinner(char[] board, char player) {
        // Check the 8 possible winning lines:
        // Rows
        if ((board[0] == player && board[1] == player && board[2] == player) ||
            (board[3] == player && board[4] == player && board[5] == player) ||
            (board[6] == player && board[7] == player && board[8] == player) ||
            // Columns
            (board[0] == player && board[3] == player && board[6] == player) ||
            (board[1] == player && board[4] == player && board[7] == player) ||
            (board[2] == player && board[5] == player && board[8] == player) ||
            // Diagonals
            (board[0] == player && board[4] == player && board[8] == player) ||
            (board[2] == player && board[4] == player && board[6] == player)) {
            return true;
        }
        return false;
    }
}
