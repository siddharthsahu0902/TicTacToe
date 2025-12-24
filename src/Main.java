import models.GameStatus;
import models.Player;
import models.PlayingPiece.PlayingPiece;
import models.PlayingPiece.PlayingPieceO;
import models.PlayingPiece.PlayingPieceX;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.initializeGame();
        GameStatus status = game.playGame();
        System.out.print("\n===>>> GAME OVER: ");
        switch (status) {
            case WIN:
                Player winner = game.getWinner();
                System.out.print(winner.getName() + " won the game");
                break;
            case DRAW:
                System.out.print(" Its a Draw!");
                break;
            default:
                System.out.print(" Game Ends");
                break;
        }


    }
}