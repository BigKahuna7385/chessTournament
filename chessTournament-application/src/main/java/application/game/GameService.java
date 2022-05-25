package application.game;

import game.Game;
import game.GameRepository;
import game.ChessResult;
import player.Player;
import player.PlayerRepository;
import round.Round;
import round.RoundRepository;
import application.exceptions.GameAlreadyAddedException;
import application.exceptions.PlayerNotRegisteredException;
import exceptions.InvalidResultException;

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

    public ChessResult getResultOf(int gameId) {
        Game game = gameRepository.getGameById(gameId);
        if (gameRepository.contains(game) && game.getResult() != null)
            return game.getResult();
        return null;
    }

    public Game createNew(Player whitePlayer, Player blackPlayer) throws PlayerNotRegisteredException, GameAlreadyAddedException {
        if (!playerRepository.contains(whitePlayer) || !playerRepository.contains(blackPlayer))
            throw new PlayerNotRegisteredException();

        Game game = new Game(whitePlayer, blackPlayer, getNextGameId());

        if (gameRepository.contains(game))
            throw new GameAlreadyAddedException();

        gameRepository.add(game);

        return game;
    }

    private int getNextGameId() {
        return gameRepository.list().size();
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


    public Game getGameById(int gameId) {
        return gameRepository.getGameById(gameId);
    }

    public void setWhiteWon(Game game) throws InvalidResultException {
        game.setResult(new ChessResult(true, false, false));
    }

    public void setBlackWon(Game game) throws InvalidResultException {
        game.setResult(new ChessResult(false, true, false));
    }

    public void setIsDrawn(Game game) throws InvalidResultException {
        game.setResult(new ChessResult(false, false, true));
    }

    public Game getGameBetween(Player player, Player opponent) {
        for (Game game : gameRepository.list()) {
            if (game.equals(new Game(player, opponent, 0)))
                return game;
        }
        return null;
    }


    public Player getNextOpponentFor(Player player, List<Player> playerAlreadyInGames) {
        for (Player possibleOpponent : playerRepository.listSortedByRanking()) {
            if (possibleOpponent == player)
                continue;
            if (playerAlreadyInGames.size() > 0 && playerAlreadyInGames.contains(possibleOpponent))
                continue;
            if (getGameBetween(player, possibleOpponent) == null) return possibleOpponent;
        }
        return null;
    }
}
