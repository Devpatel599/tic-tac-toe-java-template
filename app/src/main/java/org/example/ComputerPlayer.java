package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComputerPlayer {
    private final Random random = new Random();

    public int chooseMove(Board board, char computer, char human, int moves) {
        // Rule 1: First move → take corner
        if (moves == 0) {
            for (int pos : new int[]{1, 3, 7, 9}) {
                if (board.isCellEmpty(pos)) return pos;
            }
        }

        // Rule 2: Second move → center
        if (moves == 1 && board.isCellEmpty(5)) return 5;

        // Rule 3: Win if possible
        for (int i = 1; i <= 9; i++) {
            if (board.isCellEmpty(i)) {
                board.placeMove(i, computer);
                if (board.isWinner(computer)) {
                    board.placeMove(i, (char) ('0' + i)); // Undo move
                    return i;
                }
                board.placeMove(i, (char) ('0' + i)); // Undo move
            }
        }

        // Rule 4: Block opponent
        for (int i = 1; i <= 9; i++) {
            if (board.isCellEmpty(i)) {
                board.placeMove(i, human);
                if (board.isWinner(human)) {
                    board.placeMove(i, (char) ('0' + i)); // Undo move
                    return i;
                }
                board.placeMove(i, (char) ('0' + i)); // Undo move
            }
        }

        // Rule 5: Random available move
        List<Integer> available = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            if (board.isCellEmpty(i)) available.add(i);
        }
        return available.get(random.nextInt(available.size()));
    }
}
