package domain.repositories;

import domain.aggregates.Player;

import java.util.List;

public interface PlayerRepository {

    void add(Player player);
    void Remove(Player player);
    void Update(Player player);
    List<Player> List();

}
