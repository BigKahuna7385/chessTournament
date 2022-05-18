package Game;
import Player.Player;
import exceptions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    void createGame() throws InvalidListNumberException, InvalidPlayerInfoException, InvalidPlayerNameExeption, InvalidRatingNumberException, InvalidRatingException {
        Player whitePlayer = Player.builder().playerInfo("Daniel", "Burger", "SF Oberhausen-Rheinhausen", 12).rating(null, 1448).build();
        Player blackPlayer = Player.builder().playerInfo("Denis", "Graf", "SF Neureut 1953 e.V.", 45).rating(null, 1248).build();
        Game game = new Game(whitePlayer,blackPlayer);

        assertAll("game",
                ()-> assertEquals(whitePlayer, game.getWhitePlayer()),
                ()-> assertEquals(blackPlayer, game.getBlackPlayer()),
                ()-> assertEquals(null, game.getResult()));
    }

    @Test
    void compareGames() throws InvalidListNumberException, InvalidPlayerInfoException, InvalidPlayerNameExeption, InvalidRatingNumberException, InvalidRatingException {
        Player whitePlayer = Player.builder().playerInfo("Daniel", "Burger", "SF Oberhausen-Rheinhausen", 12).rating(null, 1448).build();
        Player blackPlayer = Player.builder().playerInfo("Denis", "Graf", "SF Neureut 1953 e.V.", 45).rating(null, 1248).build();
        Game game1 = new Game(whitePlayer,blackPlayer);
        Game game2 = new Game(whitePlayer,blackPlayer);
        assertNotEquals(game1,game2);
    }

    @Test
    void addWhiteWonResult() throws InvalidListNumberException, InvalidPlayerInfoException, InvalidPlayerNameExeption, InvalidRatingNumberException, InvalidRatingException, InvalidResultException {
        Player whitePlayer = Player.builder().playerInfo("Daniel", "Burger", "SF Oberhausen-Rheinhausen", 12).rating(null, 1448).build();
        Player blackPlayer = Player.builder().playerInfo("Denis", "Graf", "SF Neureut 1953 e.V.", 45).rating(null, 1248).build();
        Game game = new Game(whitePlayer,blackPlayer);
        Result result = new Result(true,false,false);
        game.setResult(result);
        assert(game.getResult().hasWhiteWon());
    }

    @Test
    void addBLackWonResult() throws InvalidListNumberException, InvalidPlayerInfoException, InvalidPlayerNameExeption, InvalidRatingNumberException, InvalidRatingException, InvalidResultException {
        Player whitePlayer = Player.builder().playerInfo("Daniel", "Burger", "SF Oberhausen-Rheinhausen", 12).rating(null, 1448).build();
        Player blackPlayer = Player.builder().playerInfo("Denis", "Graf", "SF Neureut 1953 e.V.", 45).rating(null, 1248).build();
        Game game = new Game(whitePlayer,blackPlayer);
        Result result = new Result(false,true,false);
        game.setResult(result);
        assert(game.getResult().hasBlackWon());
    }

    @Test
    void addDrawnResult() throws InvalidListNumberException, InvalidPlayerInfoException, InvalidPlayerNameExeption, InvalidRatingNumberException, InvalidRatingException, InvalidResultException {
        Player whitePlayer = Player.builder().playerInfo("Daniel", "Burger", "SF Oberhausen-Rheinhausen", 12).rating(null, 1448).build();
        Player blackPlayer = Player.builder().playerInfo("Denis", "Graf", "SF Neureut 1953 e.V.", 45).rating(null, 1248).build();
        Game game = new Game(whitePlayer,blackPlayer);
        Result result = new Result(false,false,true);
        game.setResult(result);
        assert(game.getResult().isDraw());
    }

    @Test
    void checkTwoGamesWithSameResult() throws InvalidListNumberException, InvalidPlayerInfoException, InvalidPlayerNameExeption, InvalidRatingNumberException, InvalidRatingException, InvalidResultException {
        Player Player1 = Player.builder().playerInfo("Daniel", "Burger", "SF Oberhausen-Rheinhausen", 12).rating(null, 1448).build();
        Player Player2 = Player.builder().playerInfo("Denis", "Graf", "SF Neureut 1953 e.V.", 45).rating(null, 1248).build();
        Game game1 = new Game(Player1,Player2);
        Result result1 = new Result(true,false,false);
        game1.setResult(result1);
        Game game2 = new Game(Player2,Player1);
        Result result2 = new Result(true,false,false);
        game2.setResult(result2);
        assertEquals(game1.getResult(), game2.getResult());
    }


}
