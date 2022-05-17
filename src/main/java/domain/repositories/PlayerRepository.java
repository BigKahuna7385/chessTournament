package domain.repositories;

import domain.aggregates.Player;

import java.util.List;

public interface PlayerRepository {

    void add(Player player);
    void remove(Player player);
    void update(Player player);
    List<Player> list();

    boolean contains(Player player);

}
