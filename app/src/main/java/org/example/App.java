package org.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;
        int xWins = 0, oWins = 0, ties = 0;
        char nextStartingPlayer = 'X';

        do {
            Game game = new Game(scanner, nextStartingPlayer);
            char winner = game.play();

            if (winner == 'X') {
                xWins++;
                nextStartingPlayer = 'O';
            } else if (winner == 'O') {
                oWins++;
                nextStartingPlayer = 'X';
            } else {
                ties++;
                nextStartingPlayer = (nextStartingPlayer == 'X') ? 'O' : 'X';
            }

            Utils.printGameLog(xWins, oWins, ties);
            playAgain = Utils.promptPlayAgain(scanner);

        } while (playAgain);

        Utils.writeGameLogToFile(xWins, oWins, ties);
        System.out.println("Goodbye!");
        scanner.close();
    }
}
