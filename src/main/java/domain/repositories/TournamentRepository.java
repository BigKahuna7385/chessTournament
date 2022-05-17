package domain.repositories;



import domain.entities.Round;

import java.util.List;

public interface TournamentRepository {

    void add(Round round);

    void Remove(Round round);

    void Update(Round round);

    List<Round> List();
}
