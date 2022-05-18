package application;

import Game.GameRepository;
import Player.PlayerRepository;
import Round.RoundRepository;
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

    private void initializeServices(){
        gameService = new GameService(gameRepository,playerRepository,roundRepository);
        roundService = new RoundService(gameRepository,playerRepository,roundRepository,gameService);
        playerService = new PlayerService(playerRepository,gameService);
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
