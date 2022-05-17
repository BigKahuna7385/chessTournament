package domain.entities;

import domain.aggregates.Player;
import domain.valueobjects.Result;

import java.util.Objects;
import java.util.UUID;

public class Game {

    private final Player whitePlayer;
    private final Player blackPlayer;
    private Result result;

    private final String uuid;

    public Game(Player whitePlayer, Player blackPlayer) {
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        uuid = UUID.randomUUID().toString();
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Player getWhitePlayer() {
        return whitePlayer;
    }

    public Player getBlackPlayer() {
        return blackPlayer;
    }

    public Result getResult() {
        return result;
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
