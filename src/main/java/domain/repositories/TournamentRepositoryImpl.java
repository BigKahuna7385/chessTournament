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
    public void remove(Round round) {
        roundList.remove(round);
    }

    @Override
    public void update(Round round) {
        roundList.remove(round);
        roundList.add(round);
    }

    @Override
    public List<Round> list() {
        return roundList;
    }
}
