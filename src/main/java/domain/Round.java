package domain;

import domain.entities.Game;

public class Round {

    private final Game[] games;

    public Round(Game[] games) {
        this.games = games;
    }

    public Game[] getGames() {
        return games;
    }
}
