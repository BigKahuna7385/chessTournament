package repositories;

import round.Round;
import round.RoundRepository;

import java.util.ArrayList;
import java.util.List;

public class RoundRepositoryImpl implements RoundRepository {

    private final List<Round> roundList;

    public RoundRepositoryImpl() {
        this.roundList = new ArrayList<>();
    }

    @Override
    public void add(Round round) {
        roundList.add(round);
    }

    @Override
    public List<Round> list() {
        return roundList;
    }

    @Override
    public void update(Round round) {
        roundList.remove(round);
        roundList.add(round);
    }

    @Override
    public void remove(Round round) {
        roundList.remove(round);
    }
}
