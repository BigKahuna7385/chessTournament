package player;

import game.Game;

public class PlayerUtils {
    private Player player;

    public PlayerUtils has(Player player) {
        this.player = player;
        return this;
    }

    public boolean Won(Game game) {
        if (player == game.getBlackPlayer() && game.getResult().hasBlackWon()) return true;
        else return player == game.getWhitePlayer() && game.getResult().hasWhiteWon();
    }

    public boolean Drawn(Game game) {
        if (game.getBlackPlayer() == player || game.getWhitePlayer() == player) return game.getResult().isDrawn();
        return false;
    }

    public PlayerUtils getOpponentOf(Player player) {
        this.player = player;
        return this;
    }

    public Player In(Game game) {
        if (game == null)
            return null;
        if (game.getWhitePlayer() == player)
            return game.getBlackPlayer();
        if (game.getBlackPlayer() == player)
            return game.getWhitePlayer();
        return null;
    }
}
