package repositories;

import Round.Round;
import Round.RoundRepository;

import java.util.List;

public class RoundRepositoryImpl implements RoundRepository {

    private List<Round> roundList;

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
