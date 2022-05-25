package player;

import game.Game;

public class TournamentRatingCalculator {

    private Game[] games;
    private Player player;
    private final BuchholzScore buchholzScore;
    private final SonnebornBergerScore sonnebornBergerScore;

    public TournamentRatingCalculator() {
        this.buchholzScore = new BuchholzScore();
        this.sonnebornBergerScore = new SonnebornBergerScore();
    }

    public TournamentRatingCalculator games(Game[] games) {
        this.games = games;
        return this;
    }

    public TournamentRatingCalculator player(Player player) {
        this.player = player;
        return this;
    }

    public TournamentRating calculate() {
        return new TournamentRating(buchholzScore.calculateBuchholzScoreWith(games, player),
                sonnebornBergerScore.calculateSonnebornBergerScoreWith(games, player));
    }

}
