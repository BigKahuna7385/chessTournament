package round;

import game.Game;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round = (Round) o;
        return id == round.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
