package game;

import player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class GameTest {

    @Test
    void createGame() {
        Player whitePlayer = mock(Player.class);
        Player blackPlayer = mock(Player.class);
        Game game = new Game(whitePlayer, blackPlayer,0);

        assertAll("game",
                () -> assertEquals(whitePlayer, game.getWhitePlayer()),
                () -> assertEquals(blackPlayer, game.getBlackPlayer()),
                () -> assertNull(game.getResult()));
    }

    @Test
    void compareGames() {
        Player whitePlayer = mock(Player.class);
        Player blackPlayer = mock(Player.class);
        Game game1 = new Game(whitePlayer, blackPlayer,0);
        Game game2 = new Game(whitePlayer, blackPlayer,1);
        assertNotEquals(game1, game2);
    }

    @Test
    void addResult()  {
        Player whitePlayer = mock(Player.class);
        Player blackPlayer = mock(Player.class);
        Game game = new Game(whitePlayer, blackPlayer,0);
        ChessResult chessResult = mock(ChessResult.class);
        assert (game.getResult() == null);
        game.setResult(chessResult);
        assert (game.getResult() != null);
    }

}