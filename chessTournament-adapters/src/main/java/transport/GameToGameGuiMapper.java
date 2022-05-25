package transport;

import game.Game;

public class GameToGameGuiMapper {
    public GameUiModel map(Game game) {
        return new GameUiModel(
                game.getId(),
                game.getWhitePlayer().getFullName(),
                game.getBlackPlayer().getFullName(),
                game.getResult() == null ? "" : game.getResult().toString()
        );
    }
}
