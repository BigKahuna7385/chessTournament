package Round;

import Game.Game;

public class Round {

    private final Game[] games;
    private final int id;
    private boolean closed;

    public Round(Game[] games, int id) {
        this.games = games;
        this.id = id;
        closed = false;
    }

    public Game[] getGames() {
        return games;
    }

    public int getId() {
        return id;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }
}
