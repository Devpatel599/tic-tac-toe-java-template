package org.example;

public class Board {
    private final char[] board;

    public Board() {
        this.board = new char[9];
        for (int i = 0; i < 9; i++) {
            board[i] = (char) ('1' + i);
        }
    }

    public void print() {
        System.out.println();
        System.out.println("   " + board[0] + "  |  " + board[1] + "  |  " + board[2]);
        System.out.println("  -----+-----+-----");
        System.out.println("   " + board[3] + "  |  " + board[4] + "  |  " + board[5]);
        System.out.println("  -----+-----+-----");
        System.out.println("   " + board[6] + "  |  " + board[7] + "  |  " + board[8]);
        System.out.println();
    }

    public boolean isCellEmpty(int position) {
        return board[position - 1] != 'X' && board[position - 1] != 'O';
    }

    public void placeMove(int position, char player) {
        board[position - 1] = player;
    }

    public boolean isWinner(char player) {
        return (board[0] == player && board[1] == player && board[2] == player) ||
               (board[3] == player && board[4] == player && board[5] == player) ||
               (board[6] == player && board[7] == player && board[8] == player) ||
               (board[0] == player && board[3] == player && board[6] == player) ||
               (board[1] == player && board[4] == player && board[7] == player) ||
               (board[2] == player && board[5] == player && board[8] == player) ||
               (board[0] == player && board[4] == player && board[8] == player) ||
               (board[2] == player && board[4] == player && board[6] == player);
    }
}



