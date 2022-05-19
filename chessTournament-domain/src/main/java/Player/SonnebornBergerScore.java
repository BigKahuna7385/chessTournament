package Player;

import Game.Game;

public class SonnebornBergerScore {

    public double calculateSonnebornBergerScoreWith(Game[] gamesOf, Player player) {
        double sonnebornBergerScore = 0;
        for (Game game : gamesOf) {
            if (player.getOpponentIn(game) != null) {
                if (player.hasWon(game))
                    sonnebornBergerScore = sonnebornBergerScore + player.getOpponentIn(game).getScore();
                if (player.hasDrawn(game))
                    sonnebornBergerScore = sonnebornBergerScore + player.getOpponentIn(game).getScore() / 2;
            }
        }
        return sonnebornBergerScore;
    }

}
