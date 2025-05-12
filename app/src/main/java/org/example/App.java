package org.example;

import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;
        int xWins = 0, oWins = 0, ties = 0;

        do {
            System.out.println("Welcome to Tic-Tac-Toe!");
            System.out.println("What kind of game would you like to play?");
            System.out.println("1. Human vs. Human");
            System.out.println("2. Human vs. Computer");
            System.out.println("3. Computer vs. Human");
            System.out.print("What is your selection? ");

            int mode;
            while (true) {
                try {
                    mode = Integer.parseInt(scanner.nextLine());
                    if (mode >= 1 && mode <= 3) break;
                    System.out.println("Invalid input. Choose 1, 2, or 3.");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Choose 1, 2, or 3.");
                }
            }

            Game game = new Game(scanner, mode);
            char winner = game.play();

            if (winner == 'X') xWins++;
            else if (winner == 'O') oWins++;
            else ties++;

            Utils.printGameLog(xWins, oWins, ties);
            playAgain = Utils.promptPlayAgain(scanner);

        } while (playAgain);

        Utils.writeGameLogToFile(xWins, oWins, ties);
        System.out.println("Goodbye!");
        scanner.close();
    }
}