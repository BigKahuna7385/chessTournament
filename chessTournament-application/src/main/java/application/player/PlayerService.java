package application.player;

import game.Game;
import player.Player;
import player.PlayerRepository;
import player.TournamentRating;
import application.exceptions.PlayerAlreadyRegistered;
import application.game.GameService;

import java.util.ArrayList;
import java.util.List;

public class PlayerService {

    private final PlayerRepository playerRepository;
    private final GameService gameService;
    private int id;
    private Player player;

    public PlayerService(PlayerRepository playerRepository, GameService gameService) {
        this.playerRepository = playerRepository;
        this.gameService = gameService;
        id = 1;
    }

    public void createNewPlayer(Player player) throws PlayerAlreadyRegistered {
        if (playerRepository.contains(player))
            throw new PlayerAlreadyRegistered();
        playerRepository.add(player);
    }

    public void removePlayer(Player player) {
        playerRepository.remove(player);
    }

    public TournamentRating calculateTournamentRatingFor(Player player) {
        return TournamentRating.calculateTournamentRating().player(player).games(gameService.getAllGamesOf(player)).calculate();
    }

    public Player[] getRankedPlayers() {
        return playerRepository.listSortedByRanking().toArray(new Player[0]);
    }

    public Object[] findPlayerByName(String searchTerm) {
        List<Player> playerList = new ArrayList<>();
        for (Player player : playerRepository.list()) {
            if (player.getFullName().contains(searchTerm))
                playerList.add(player);
        }
        return playerList.toArray(new Player[0]);
    }

    public Player findPlayerById(int id) {
        for (Player player : playerRepository.list()) {
            if (player.getId() == id)
                return player;
        }
        return null;
    }

    public Player[] getAllRegisteredPlayers() {
        return playerRepository.list().toArray(new Player[0]);
    }

    public int getNewId() {
        return id++;
    }

    public void modifyPlayer(Player player) {
        playerRepository.update(player);
    }

    public PlayerService getScoreOf(Player player) {
        this.player = player;
        return this;
    }

    public String vs(Player opponent) {
        Game game = gameService.getGameBetween(player, opponent);
        if (game == null) return "";
        return game.getScoreOf(player);
    }
}
