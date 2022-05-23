package transport;

import Game.Game;

public class GameToGameGuiMapper {
    public GameUiModel map(Game game) {
        return map(game);
    }

    public GameUiModel apply(Game game) {
        return new GameUiModel(
                game.getId(),
                game.getWhitePlayer().getFullName(),
                game.getBlackPlayer().getFullName(),
                game.getResult() == null ? "" : game.getResult().toString()
        );
    }
}
