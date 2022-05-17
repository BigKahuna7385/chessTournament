package domain.entities;

import domain.entities.Game;

public class Round {

    private final Game[] games;

    private final int id;

    public Round(Game[] games, int id) {
        this.games = games;
        this.id = id;
    }

    public Game[] getGames() {
        return games;
    }

    public int getId() {
        return id;
    }
}
