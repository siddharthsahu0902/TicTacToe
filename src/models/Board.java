package models;

import models.PlayingPiece.PlayingPiece;

public class Board {
    private PlayingPiece[][] board;
    private int size;
    public Board(int size) {
        this.size = size;
        this.board = new PlayingPiece[size][size];
    }

    public boolean addPiece(PlayingPiece piece, int i, int j) {
        if(board[i][j] != null || (i>= board.length && j>= board[0].length)) {
            return false;
        }
        board[i][j] = piece;
        return true;
    }

    public void printBoard() {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                String s = " ";
                if(board[i][j] != null) {
                    s = board[i][j].getPlayingType().name();
                }
                System.out.print("| " + s + " |");
            }
            System.out.println();
        }
    }

    public int getEmptyCells(Board board) {
        int emptyCells = 0;
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                if(board.board[i][j] == null) {
                    emptyCells++;
                }
            }
        }
        return emptyCells;
    }

    public int getSize() {
        return size;
    }

    public PlayingPiece[][] getBoard() {
        return board;
    }
}
