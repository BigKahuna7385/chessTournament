package usecases;

import domain.aggregates.Player;
import domain.repositories.PlayerRepository;
import usecases.exceptions.PlayerAlreadyRegistered;

public class CreatePlayer {

    private final PlayerRepository playerRepository;

    public CreatePlayer(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public void create(Player player) throws PlayerAlreadyRegistered {
        if (playerRepository.contains(player))
            throw new PlayerAlreadyRegistered();
        Player newPlayer =  Player.builder()
                .playerInfo(player.getPlayerInfo())
                .rating(player.getRating())
                .build();
        playerRepository.add(newPlayer);
    }
}
