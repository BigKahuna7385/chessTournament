package player;

import java.util.List;

public interface PlayerRepository {

    void add(Player player);

    void remove(Player player);

    void update(Player player);

    List<Player> list();

    List<Player> listSortedByRanking();

    boolean contains(Player player);

}
