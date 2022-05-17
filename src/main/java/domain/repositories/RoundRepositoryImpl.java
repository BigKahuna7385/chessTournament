package domain.repositories;

import domain.entities.Game;

import java.util.ArrayList;
import java.util.List;

public class RoundRepositoryImpl implements RoundRepository {

    private final List<Game> gameList;

    public RoundRepositoryImpl() {
        gameList = new ArrayList<>();
    }

    @Override
    public void add(Game game) {
        gameList.add(game);
    }

    @Override
    public void remove(Game game) {
        gameList.remove(game);
    }

    @Override
    public void update(Game game) {
        gameList.remove(game);
        gameList.add(game);
    }

    @Override
    public List<Game> list() {
        return gameList;
    }
}
