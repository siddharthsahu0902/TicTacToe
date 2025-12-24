package models.PlayingPiece;

public class PlayingPiece {
    private PlayingType playingType;

    PlayingPiece(PlayingType playingType) {
        this.playingType = playingType;
    }

    public PlayingType getPlayingType() {
        return playingType;
    }
}
