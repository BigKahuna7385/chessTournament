package application;

import game.GameRepository;
import player.PlayerRepository;
import round.RoundRepository;
import application.exceptions.GameAlreadyAddedException;
import application.exceptions.PlayerNotRegisteredException;
import application.exceptions.TournamentServicesAreNotInitializedException;
import application.game.GameService;
import application.player.PlayerService;
import application.round.RoundService;

public class Tournament {

    private final GameRepository gameRepository;
    private final RoundRepository roundRepository;
    private final PlayerRepository playerRepository;

    private GameService gameService;
    private PlayerService playerService;
    private RoundService roundService;

    public Tournament(GameRepository gameRepository, RoundRepository roundRepository, PlayerRepository playerRepository) {
        this.gameRepository = gameRepository;
        this.roundRepository = roundRepository;
        this.playerRepository = playerRepository;
    }

    public void initializeServices() {
        gameService = new GameService(gameRepository, playerRepository, roundRepository);
        playerService = new PlayerService(playerRepository, gameService);
        roundService = new RoundService(roundRepository, gameService, playerService);
    }

    public void startTournament() throws TournamentServicesAreNotInitializedException, GameAlreadyAddedException, PlayerNotRegisteredException {
        if (gameService == null || roundService == null || playerService == null)
            throw new TournamentServicesAreNotInitializedException();
        roundService.createFirstRound();
    }

    public GameService getGameService() {
        return gameService;
    }

    public PlayerService getPlayerService() {
        return playerService;
    }

    public RoundService getRoundService() {
        return roundService;
    }

}
