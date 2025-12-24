import models.Board;
import models.GameStatus;
import models.Player;
import models.PlayingPiece.PlayingPiece;
import models.PlayingPiece.PlayingPieceO;
import models.PlayingPiece.PlayingPieceX;
import models.PlayingPiece.PlayingType;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class TicTacToe {
    Deque<Player>players;
    Board board;
    Player winner;

    public void initializeGame(){
        PlayingPiece playingPieceX = new PlayingPieceX();
        PlayingPiece playingPieceO = new PlayingPieceO();

        Player player1 = new Player("GYaanii", playingPieceX);
        Player player2 = new Player("Vas", playingPieceO);

        players = new ArrayDeque<>();

        players.addLast(player1);
        players.addLast(player2);

        board = new Board(3);
    }

    public GameStatus playGame(){
        boolean gameEnd = false;

        while(!gameEnd){
            Player currentPlayer = players.removeFirst();

            board.printBoard();
            int emptyCells = board.getEmptyCells(board);
            if(emptyCells == 0){
                gameEnd = true;
                continue;
            }

            System.out.println("Player : " + currentPlayer.getName() + " Enter your position [row,column]");

            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.parseInt(values[0].trim());
            int inputColumn = Integer.parseInt(values[1].trim());

            boolean is_added = board.addPiece(currentPlayer.getPlayingPiece(), inputRow, inputColumn);
            if(!is_added){
                System.out.println("Problem in adding a piece, please try again.");
                players.addFirst(currentPlayer);
                continue;
            }
            players.addLast(currentPlayer);

            gameEnd = checkGame(board, inputRow, inputColumn, currentPlayer.getPlayingPiece());
            if(gameEnd){
                winner = currentPlayer;
                board.printBoard();
                return GameStatus.WIN;
            }
        }
        return GameStatus.DRAW;
    }

    private boolean checkGame(Board boardie, int inputRow, int inputColumn, PlayingPiece playingPiece) {
        boolean leftDiagonal = true;
        boolean rightDiagonal = true;
        boolean column = true;
        boolean row = true;
        PlayingPiece[][] board = boardie.getBoard();
        PlayingType playingtype = playingPiece.getPlayingType();

        for(int i = 0; i < boardie.getSize(); i++){
            if(board[inputRow][i]==null || board[inputRow][i].getPlayingType()!=playingtype) {
                row = false;
            }
        }

        for(int i = 0; i < boardie.getSize(); i++){
            if(board[i][inputColumn]==null || board[i][inputColumn].getPlayingType()!=playingtype){
                column=false;
            }
        }

        for(int i = 0; i < boardie.getSize(); i++){
            if(board[i][i]==null || board[i][i].getPlayingType()!=playingtype){
                leftDiagonal=false;
            }
        }

        for(int i = 0, j = boardie.getSize()-1; i < boardie.getSize(); i++, j--){
            if(board[i][j]==null || board[i][j].getPlayingType()!=playingtype){
                rightDiagonal=false;
            }
        }

        return leftDiagonal || rightDiagonal || row || column;
    }

    public Player getWinner() {
        return winner;
    }
}
