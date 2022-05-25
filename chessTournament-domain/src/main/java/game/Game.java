package game;

import player.Player;

import java.util.Objects;

public class Game {

    private final Player whitePlayer;
    private final Player blackPlayer;
    private ChessResult chessResult;
    private final int id;

    public Game(Player whitePlayer, Player blackPlayer, int id) {
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        this.id = id;
    }

    public void setResult(ChessResult chessResult) {
        this.chessResult = chessResult;
        whitePlayer.addScoreFrom(this);
        blackPlayer.addScoreFrom(this);
    }

    public Player getWhitePlayer() {
        return whitePlayer;
    }

    public Player getBlackPlayer() {
        return blackPlayer;
    }

    public ChessResult getResult() {
        return chessResult;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return id == game.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
