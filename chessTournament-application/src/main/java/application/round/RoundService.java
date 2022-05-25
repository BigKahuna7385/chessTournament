package application.round;

import game.Game;
import player.Player;
import player.TournamentRating;
import round.Round;
import round.RoundRepository;
import application.exceptions.CurrentRoundIsNotClosedException;
import application.exceptions.GameAlreadyAddedException;
import application.exceptions.NotAllGamesAreFinishedException;
import application.exceptions.PlayerNotRegisteredException;
import application.game.GameService;
import application.player.PlayerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RoundService {
    private final RoundRepository roundRepository;
    private final GameService gameService;
    private final PlayerService playerService;

    public RoundService(RoundRepository roundRepository, GameService gameService, PlayerService playerService) {
        this.roundRepository = roundRepository;
        this.gameService = gameService;
        this.playerService = playerService;
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
        for (Player player : playerService.getAllRegisteredPlayers()) {
            calculateRatingNumberFor(player);
        }
    }

    private Game[] findNewPairings() throws GameAlreadyAddedException, PlayerNotRegisteredException {
        Player[] rankedPlayerList = playerService.getRankedPlayers();
        List<Game> gameList = new ArrayList<>();
        for (int i = 0; i < rankedPlayerList.length; i++) {
            if (rankedPlayerList.length < i + 1)
                break;
            gameList.add(gameService.createNew(rankedPlayerList[i++], rankedPlayerList[i]));
        }
        return gameList.toArray(new Game[0]);
    }

    private void calculateRatingNumberFor(Player player) {
        Game[] games = gameService.getAllGamesOf(player);
        player.setTournamentRating(TournamentRating.calculateTournamentRating().player(player).games(games).calculate());
    }

    public Round getCurrentRound() {
        if (roundRepository.list().size() == 0) return null;
        return roundRepository.getByRoundById(getCurrentRoundNumber());
    }

    public int getCurrentRoundNumber() {
        return roundRepository.list().size();
    }

    private boolean allGamesAreFinished() throws NotAllGamesAreFinishedException {
        for (Game game : gameService.getAllGamesIn(Objects.requireNonNull(getCurrentRound()))) {
            if (game.getResult() == null) throw new NotAllGamesAreFinishedException();
        }
        return true;
    }

    public void createFirstRound() throws GameAlreadyAddedException, PlayerNotRegisteredException {
        Game[] games = findNewPairings();
        roundRepository.add(new Round(games, getCurrentRoundNumber() + 1));
    }
}
