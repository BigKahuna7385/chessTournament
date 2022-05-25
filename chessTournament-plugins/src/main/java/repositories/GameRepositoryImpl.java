package repositories;

import game.Game;
import game.GameRepository;

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
    public List<Game> list() {
        return gameList;
    }

    @Override
    public boolean contains(Game game) {
        for (Game g : gameList) {
            if (game.equals(g))
                return true;
        }
        return false;
    }

    @Override
    public Game getGameById(int gameId) {
        for (Game game : gameList) {
            if (game.getId() == gameId) return game;
        }
        return null;
    }

    @Override
    public void update(Game game) {
        gameList.remove(game);
        gameList.add(game);
    }

    @Override
    public void remove(Game game) {
        gameList.remove(game);
    }
}
