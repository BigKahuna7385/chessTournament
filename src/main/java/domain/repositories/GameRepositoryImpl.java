package domain.repositories;

import domain.entities.Game;

import java.util.ArrayList;
import java.util.List;

public class GameRepositoryImpl implements GameRepository {

    private final List<Game> gameList;

    public GameRepositoryImpl() {
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

    @Override
    public boolean contains(Game game) {
        return gameList.contains(game);
    }
}
