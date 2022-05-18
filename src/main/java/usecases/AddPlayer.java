package usecases;

import domain.aggregates.Player;
import domain.repositories.PlayerRepository;
import usecases.exceptions.PlayerAlreadyRegistered;

public class AddPlayer {

    private final PlayerRepository playerRepository;

    public AddPlayer(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public void addPlayer(Player player) throws PlayerAlreadyRegistered {
        if (playerRepository.contains(player))
            throw new PlayerAlreadyRegistered();
        playerRepository.add(player);
    }
}
