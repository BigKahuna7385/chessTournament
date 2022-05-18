package usecases;

import domain.aggregates.Player;
import domain.entities.Game;
import domain.exceptions.*;
import domain.repositories.GameRepositoryImpl;
import domain.valueobjects.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.exceptions.GameAlreadyAddedException;

public class SetGameResultTest {

    private static Game game;


    @BeforeEach
    public void init() throws InvalidListNumberException, InvalidPlayerInfoException, InvalidPlayerNameExeption, InvalidRatingNumberException, InvalidRatingException, GameAlreadyAddedException {
        GameRepositoryImpl gameRepository = new GameRepositoryImpl();
        Player whitePlayer = Player.builder().playerInfo("Daniel", "Burger", "SF Oberhausen-Rheinhausen", 12).rating(null, 1448).build();
        Player blackPlayer = Player.builder().playerInfo("Denis", "Graf", "SF Neureut 1953 e.V.", 45).rating(null, 1248).build();
        game = new Game(whitePlayer, blackPlayer);
        AddGame addGame = new AddGame(gameRepository);
        addGame.addGame(game);
    }

    @Test
    public void setWhiteWonTest() throws InvalidResultException {
        Result result = new Result(true,false,false);
        game.setResult(result);
        assert(game.getResult().hasWhiteWon());
    }

    @Test
    public void setBlackWonTest() throws InvalidResultException {
        Result result = new Result(false,true,false);
        game.setResult(result);
        assert(game.getResult().hasBlackWon());
    }

    @Test
    public void setDrawTest() throws InvalidResultException {
        Result result = new Result(false,false,true);
        game.setResult(result);
        assert(game.getResult().isDraw());
    }

}
