package usecases;

import domain.entities.Game;
import domain.repositories.GameRepositoryImpl;
import usecases.exceptions.GameAlreadyAddedException;

public class AddGame {

    private final GameRepositoryImpl roundRepository;

    public AddGame(GameRepositoryImpl roundRepository) {
        this.roundRepository = roundRepository;
    }

    public void addGame(Game game) throws GameAlreadyAddedException {
        if (roundRepository.contains(game))
            throw new GameAlreadyAddedException();
        roundRepository.add(game);
    }
}
