package application.round;

import Game.Game;
import Game.GameRepository;
import Player.Player;
import Player.PlayerRepository;
import Player.TournamentRating;
import Round.Round;
import Round.RoundRepository;
import application.exceptions.CurrentRoundIsNotClosedException;
import application.exceptions.GameAlreadyAddedException;
import application.exceptions.NotAllGamesAreFinishedException;
import application.exceptions.PlayerNotRegisteredException;
import application.game.GameService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RoundService {

    private final GameRepository gameRepository;
    private final PlayerRepository playerRepository;
    private final RoundRepository roundRepository;
    private final GameService gameService;


    public RoundService(GameRepository gameRepository, PlayerRepository playerRepository,
                        RoundRepository roundRepository, GameService gameService) {
        this.gameRepository = gameRepository;
        this.playerRepository = playerRepository;
        this.roundRepository = roundRepository;
        this.gameService = gameService;
    }

    public void createNextRound() throws CurrentRoundIsNotClosedException, GameAlreadyAddedException, PlayerNotRegisteredException {
        if (!getCurrentRound().isClosed())
            throw new CurrentRoundIsNotClosedException();
        calculateRatingNumbersForAllPlayers();
        Game[] games = findNewPairings();
        roundRepository.add(new Round(games, roundRepository.list().size() + 1));
    }

    public void closeRound() throws NotAllGamesAreFinishedException {
        if (allGamesAreFinished())
            Objects.requireNonNull(getCurrentRound()).setClosed(true);
    }

    private void calculateRatingNumbersForAllPlayers() {
        for (Player player : playerRepository.list()) {
            calculateRatingNumberFor(player);
        }
    }

    private Game[] findNewPairings() throws GameAlreadyAddedException, PlayerNotRegisteredException {
        List<Player> rankedPlayerList = playerRepository.listSortedByRanking();
        List<Game> gameList = new ArrayList<>();
        for (int i = 0; i < rankedPlayerList.size(); i++) {
            if (rankedPlayerList.size() < i + 1)
                break;
            gameList.add(gameService.createNew(rankedPlayerList.get(i++), rankedPlayerList.get(i)));

        }
        return gameList.toArray(new Game[0]);
    }

    private void calculateRatingNumberFor(Player player) {
        Game[] games = gameService.getAllGamesOf(player);
        player.setTournamentRating(TournamentRating.calculateTournamentRating().player(player).games(games).calculate());
    }

    public Round getCurrentRound() {
        if (roundRepository.list().size() == 0) return null;
        return roundRepository.list().get(roundRepository.list().size() - 1);
    }

    public int getCurrentRoundNumber() {
        return roundRepository.list().size();
    }

    private boolean allGamesAreFinished() throws NotAllGamesAreFinishedException {
        for (Game game : gameService.getAllGamesIn(Objects.requireNonNull(getCurrentRound()))) {
            if (game.getResult() == null)
                throw new NotAllGamesAreFinishedException();
        }
        return true;
    }

    public void createFirstRound() throws GameAlreadyAddedException, PlayerNotRegisteredException {
        Game[] games = findNewPairings();
        roundRepository.add(new Round(games, getCurrentRoundNumber() + 1));
    }
}
