package Game;

import Player.Player;
import exceptions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GameTest {

    @Test
    void createGame() {
        Player whitePlayer = mock(Player.class);
        Player blackPlayer = mock(Player.class);
        Game game = new Game(whitePlayer, blackPlayer);

        assertAll("game",
                () -> assertEquals(whitePlayer, game.getWhitePlayer()),
                () -> assertEquals(blackPlayer, game.getBlackPlayer()),
                () -> assertNull(game.getResult()));
    }

    @Test
    void compareGames() {
        Player whitePlayer = mock(Player.class);
        Player blackPlayer = mock(Player.class);
        Game game1 = new Game(whitePlayer, blackPlayer);
        Game game2 = new Game(whitePlayer, blackPlayer);
        assertNotEquals(game1, game2);
    }

    @Test
    void addResult()  {
        Player whitePlayer = mock(Player.class);
        Player blackPlayer = mock(Player.class);
        Game game = new Game(whitePlayer, blackPlayer);
        ChessResult chessResult = mock(ChessResult.class);
        assert (game.getResult() == null);
        game.setResult(chessResult);
        assert (game.getResult() != null);
    }

}