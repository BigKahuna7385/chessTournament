package player;

import game.Game;

public class BuchholzScore {

    public double calculateBuchholzScoreWith(Game[] gamesOf, Player player) {
        double buchholzScore = 0;
        PlayerUtils playerUtils = new PlayerUtils();
        for (Game game : gamesOf) {
            Player opponent = playerUtils.getOpponentOf(player).In(game);
            if (opponent != null)
                buchholzScore = buchholzScore + opponent.getScore();
        }
        return buchholzScore;
    }

}
