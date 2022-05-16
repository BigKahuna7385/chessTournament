package domain.aggregates;

import domain.valueobjects.Result;

public class Game {

    private final Player whitePlayer;
    private final Player blackPlayer;
    private Result result;

    public Game(Player whitePlayer, Player blackPlayer) {
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
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
}
