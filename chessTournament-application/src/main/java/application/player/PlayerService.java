package application.player;

import Player.Player;
import Player.PlayerRepository;
import Player.TournamentRating;
import application.exceptions.PlayerAlreadyRegistered;
import application.game.GameService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerService {

    private final PlayerRepository playerRepository;
    private final GameService gameService;
    private int id;

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

    public Player[] getPlayerRanked() {
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

}
