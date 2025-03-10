package org.example;  // Ensure package is correct

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
}
