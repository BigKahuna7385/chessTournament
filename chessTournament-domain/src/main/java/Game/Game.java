package Game;

import Player.Player;

import java.util.Objects;
import java.util.UUID;

public class Game {

    private final Player whitePlayer;
    private final Player blackPlayer;
    private ChessResult chessResult;

    private final String uuid;

    public Game(Player whitePlayer, Player blackPlayer) {
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        uuid = UUID.randomUUID().toString();
    }

    public void setResult(ChessResult chessResult) {
        this.chessResult = chessResult;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return uuid.equals(game.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
