package player;

import game.Game;

public class SonnebornBergerScore {

    public double calculateSonnebornBergerScoreWith(Game[] gamesOf, Player player) {
        double sonnebornBergerScore = 0;
        PlayerUtils playerUtils = new PlayerUtils();
        for (Game game : gamesOf) {
            Player opponent = playerUtils.getOpponentOf(player).In(game);
            if (opponent != null) {
                playerUtils.has(player).Won(game);
                if (playerUtils.has(player).Won(game))
                    sonnebornBergerScore = sonnebornBergerScore + opponent.getScore();
                if (playerUtils.has(player).Drawn(game))
                    sonnebornBergerScore = sonnebornBergerScore + opponent.getScore() / 2;
            }
        }
        return sonnebornBergerScore;
    }

}
