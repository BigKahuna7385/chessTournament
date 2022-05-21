package application.game;

import Game.Game;
import Game.GameRepository;
import Game.ChessResult;
import Player.Player;
import Player.PlayerRepository;
import Round.Round;
import Round.RoundRepository;
import application.exceptions.GameAlreadyAddedException;
import application.exceptions.PlayerNotRegisteredException;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    private final GameRepository gameRepository;
    private final PlayerRepository playerRepository;
    private final RoundRepository roundRepository;

    public GameService(GameRepository gameRepository, PlayerRepository playerRepository, RoundRepository roundRepository) {
        this.gameRepository = gameRepository;
        this.playerRepository = playerRepository;
        this.roundRepository = roundRepository;
    }

    public Game getGameOfPlayerInRound(Round round, Player player) {
        for (Game game : round.getGames()) {
            if (game.getWhitePlayer().equals(player) || game.getBlackPlayer().equals(player))
                return game;
        }
        return null;
    }

    public ChessResult getResultOf(Game game) {
        if (gameRepository.contains(game) && game.getResult() != null)
            return game.getResult();
        return null;
    }

    public Game createNew(Player whitePlayer, Player blackPlayer) throws PlayerNotRegisteredException, GameAlreadyAddedException {
        if (!playerRepository.contains(whitePlayer) || !playerRepository.contains(blackPlayer))
            throw new PlayerNotRegisteredException();

        Game game = new Game(whitePlayer, blackPlayer);

        if (gameRepository.contains(game))
            throw new GameAlreadyAddedException();

        gameRepository.add(game);

        return game;
    }

    public Game[] getAllGamesOf(Player player) {
        List<Game> gameList = new ArrayList<>();

        for (Game game : gameRepository.list()) {
            if (game.getBlackPlayer().equals(player) || game.getWhitePlayer().equals(player))
                gameList.add(game);
        }

        return gameList.toArray(new Game[0]);
    }

    public Game[] getAllGamesIn(Round round) {
        return round.getGames();
    }

    public Game[] getAllGames() {
        return gameRepository.list().toArray(new Game[0]);
    }


}
