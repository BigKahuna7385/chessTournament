package Player;

import Game.Game;

public class TournamentRatingCalculator {

    private Game[] games;
    private Player player;

    private double buchholzScore;
    private double sonnebornBergerScore;
        public TournamentRatingCalculator() {
    }

    public TournamentRatingCalculator games(Game[] games){
            this.games = games;
            return this;
    }

    public TournamentRatingCalculator player(Player player){
        this.player = player;
        return this;
    }

    public TournamentRating build(){
            calculateBuchholzScore();
            calculateSonnebornScore();
            return new TournamentRating(buchholzScore,sonnebornBergerScore);
    }

    private void calculateSonnebornScore() {
    }

    private void calculateBuchholzScore() {


    }


}
