package domain.repositories;

import domain.entities.Round;

import java.util.ArrayList;
import java.util.List;

public class TournamentRepositoryImpl implements TournamentRepository {

    private final List<Round> roundList;

    public TournamentRepositoryImpl() {
        roundList = new ArrayList<>();
    }

    @Override
    public void add(Round round) {
        roundList.add(round);
    }

    @Override
    public void Remove(Round round) {
        roundList.remove(round);
    }

    @Override
    public void Update(Round round) {
        roundList.remove(round);
        roundList.add(round);
    }

    @Override
    public List<Round> List() {
        return roundList;
    }
}
