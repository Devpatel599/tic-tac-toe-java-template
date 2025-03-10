package org.example; // Ensure consistency

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            Game game = new Game(scanner); // Ensure Game is recognized
            game.play();

            playAgain = Utils.promptPlayAgain(scanner); // Ensure Utils is recognized
        } while (playAgain);

        System.out.println("Goodbye!");
        scanner.close();
    }
}
