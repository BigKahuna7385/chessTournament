package player;

import game.Game;

public class BuchholzScore {

    public double calculateBuchholzScoreWith(Game[] gamesOf, Player player) {
        double buchholzScore = 0;
        for (Game game : gamesOf) {
            if (player.getOpponentIn(game) != null)
                buchholzScore = buchholzScore + player.getOpponentIn(game).getScore();
        }
        return buchholzScore;
    }

}
