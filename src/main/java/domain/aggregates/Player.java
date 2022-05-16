package domain.aggregates;

import domain.entities.TournamentRating;
import domain.valueobjects.Playerinfo;
import domain.valueobjects.Rating;

public class Player {
    private final Playerinfo playerinfo;
    private final Rating rating;
    private final TournamentRating tournamentRating;

    public Player(Playerinfo playerinfo, Rating rating, TournamentRating tournamentRating) {
        this.playerinfo = playerinfo;
        this.rating = rating;
        this.tournamentRating = tournamentRating;
    }

    public Playerinfo getPlayerinfo() {
        return playerinfo;
    }

    public Rating getRating() {
        return rating;
    }

    public TournamentRating getTournamentRating() {
        return tournamentRating;
    }
}
