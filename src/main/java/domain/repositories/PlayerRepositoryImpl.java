package domain.repositories;

import domain.aggregates.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerRepositoryImpl implements PlayerRepository {

    private final List<Player> playerList;

    public PlayerRepositoryImpl() {
        this.playerList = new ArrayList<>();
    }


    @Override
    public void add(Player player) {
        playerList.add(player);
    }

    @Override
    public void Remove(Player player) {
        playerList.remove(player);
    }

    @Override
    public void Update(Player player) {
        playerList.remove(player);
        playerList.add(player);
    }

    @Override
    public List<Player> List() {
        return playerList;
    }
}
