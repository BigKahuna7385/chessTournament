package repositories;

import Player.Player;
import Player.PlayerRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerRepositoryImpl implements PlayerRepository {

    private final List<Player> playerList;

    public PlayerRepositoryImpl() {
        playerList = new ArrayList<>();
    }

    @Override
    public void add(Player player) {
        playerList.add(player);
    }

    @Override
    public List<Player> list() {
        return playerList;
    }

    @Override
    public List<Player> listSortedByRanking() {
        Collections.sort(playerList);
        return playerList;
    }

    @Override
    public boolean contains(Player player) {
        for (Player p : playerList) {
            if (player.equals(p))
                return true;
        }
        return false;
    }

    @Override
    public void update(Player player) {
        playerList.remove(player);
        playerList.add(player);
    }

    @Override
    public void remove(Player player) {
        playerList.remove(player);
    }
}
