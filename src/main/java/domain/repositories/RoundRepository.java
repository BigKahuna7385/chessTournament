package domain.repositories;



import domain.entities.Game;

import java.util.List;

public interface RoundRepository {

    void add(Game game);

    void remove(Game game);

    void update(Game game);

    List<Game> list();

}
