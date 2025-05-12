package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppTest {

    private Board board;

    @BeforeEach
    void setup() {
        board = new Board();
    }

    @Test
    void testBoardInitialState() {
        for (int i = 1; i <= 9; i++) {
            assertTrue(board.isCellEmpty(i), "Cell " + i + " should be initially empty");
        }
    }

    @Test
    void testPlaceMoveAndWinner() {
        board.placeMove(1, 'X');
        board.placeMove(2, 'X');
        board.placeMove(3, 'X');
        assertTrue(board.isWinner('X'), "Player X should be the winner");
    }

    @Test
    void testNoWinnerOnEmptyBoard() {
        assertFalse(board.isWinner('X'), "No winner expected on a new board");
    }

    @Test
    void testComputerPlayerFirstMoveCorner() {
        ComputerPlayer cpu = new ComputerPlayer();
        int move = cpu.chooseMove(board, 'X', 'O', 0);
        assertTrue(move == 1 || move == 3 || move == 7 || move == 9, "First move should be a corner");
    }

    @Test
    void testGameEndsInTie() {
        board.placeMove(1, 'X');
        board.placeMove(2, 'O');
        board.placeMove(3, 'X');
        board.placeMove(4, 'X');
        board.placeMove(5, 'O');
        board.placeMove(6, 'X');
        board.placeMove(7, 'O');
        board.placeMove(8, 'X');
        board.placeMove(9, 'O');
        assertFalse(board.isWinner('X'));
        assertFalse(board.isWinner('O'));
    }
}
