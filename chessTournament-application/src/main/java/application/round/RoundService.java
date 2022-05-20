package application.round;

import Game.Game;
import Game.GameRepository;
import Player.Player;
import Player.PlayerRepository;
import Player.TournamentRating;
import Round.Round;
import Round.RoundRepository;
import application.game.GameService;

import java.util.ArrayList;
import java.util.List;

public class RoundService {

    private final GameRepository gameRepository;
    private final PlayerRepository playerRepository;
    private final RoundRepository roundRepository;
    private final GameService gameService;

    public RoundService(GameRepository gameRepository, PlayerRepository playerRepository, RoundRepository roundRepository, GameService gameService) {
        this.gameRepository = gameRepository;
        this.playerRepository = playerRepository;
        this.roundRepository = roundRepository;
        this.gameService = gameService;
    }

    public void createNextRound() {
        if (currentRoundReady())
            calculateRatingNumbers();
        Game[] games = findNewPairings();
        roundRepository.add(new Round(games, roundRepository.list().size() + 1));
    }

    private void calculateRatingNumbers() {
        for (Player player : playerRepository.list()) {
            calculateRatingNumberFor(player);
        }
    }

    private Game[] findNewPairings() {
        List<Player> rankedPlayerList = playerRepository.listSortedByRanking();
        List<Game> gameList = new ArrayList<>();
        for (int i = 0; i < rankedPlayerList.size(); i++) {
            if (rankedPlayerList.size() < i + 1)
                break;
            Game game = new Game(rankedPlayerList.get(i++), rankedPlayerList.get(i));
            gameList.add(game);
            gameRepository.add(game);
        }
        return gameList.toArray(new Game[0]);
    }

    private void calculateRatingNumberFor(Player player) {
        Game[] games = gameService.getAllGamesOf(player);
        player.setTournamentRating(TournamentRating.calculateTournamentRating().player(player).games(games).calculate());
    }

    private boolean currentRoundReady() {
        Round round = getCurrentRound();
        for (Game game:round.getGames()){
            if (game.getResult() == null)
                return false;
        }
        return true;
    }

    private Round getCurrentRound() {
        return roundRepository.list().get(roundRepository.list().size() - 1);
    }
}
