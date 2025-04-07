package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Utils {
    public static boolean promptPlayAgain(Scanner scanner) {
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

    public static int getValidMove(Scanner scanner, Board board) {
        while (true) {
            System.out.print("What is your move? ");
            String input = scanner.nextLine().trim();

            try {
                int move = Integer.parseInt(input);
                if (move < 1 || move > 9 || !board.isCellEmpty(move)) {
                    System.out.println("That is not a valid move! Try again.");
                } else {
                    return move;
                }
            } catch (NumberFormatException e) {
                System.out.println("That is not a valid move! Try again.");
            }
        }
    }

    public static void printGameLog(int xWins, int oWins, int ties) {
        System.out.println("\nThe current log is:");
        System.out.println("Player X Wins   " + xWins);
        System.out.println("Player O Wins   " + oWins);
        System.out.println("Ties            " + ties + "\n");
    }

    public static void writeGameLogToFile(int xWins, int oWins, int ties) {
        try (FileWriter writer = new FileWriter("game.txt")) {
            writer.write("Final Game Log:\n");
            writer.write("Player X Wins: " + xWins + "\n");
            writer.write("Player O Wins: " + oWins + "\n");
            writer.write("Ties: " + ties + "\n");
            System.out.println("Writing the game log to disk. Please see game.txt for the final statistics!");
        } catch (IOException e) {
            System.out.println("Error writing game log to file: " + e.getMessage());
        }
    }
}
