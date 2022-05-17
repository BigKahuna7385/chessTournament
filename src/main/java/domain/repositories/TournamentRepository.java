package domain.repositories;



import domain.entities.Round;

import java.util.List;

public interface TournamentRepository {

    void add(Round round);

    void remove(Round round);

    void update(Round round);

    List<Round> list();
}
