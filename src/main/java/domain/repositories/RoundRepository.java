package domain.repositories;



import domain.entities.Game;

import java.util.List;

public interface RoundRepository {

    void add(Game game);

    void Remove(Game game);

    void Update(Game game);

    List<Game> List();

}
