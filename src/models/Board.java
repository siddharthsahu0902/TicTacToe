package models;

public class Board {
    private PlayingType[][] board;

    Board(int size) {
        this.board = new PlayingType[size][size];
    }

    public boolean addPiece(PlayingType piece, int i, int j) {
        if(board[i][j] != null || (i>= board.length && j>= board[0].length)) {
            return false;
        }
        board[i][j] = piece;
        return true;
    }

    public void printBoard() {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                System.out.println("| " + board[i][j].toString() + " |");
            }
        }
    }
}
