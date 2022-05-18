package usecases;

import domain.aggregates.Player;
import domain.entities.Game;
import domain.exceptions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;

public class CreateGameTest {

    static Player whitePlayer;
    static Player blackPlayer;
    static CreateGame createGame;


    @BeforeAll
    public static void init() throws InvalidListNumberException, InvalidPlayerInfoException, InvalidPlayerNameExeption, InvalidRatingNumberException, InvalidRatingException {
        whitePlayer = Player.builder().playerInfo("Daniel", "Burger", "SF Oberhausen-Rheinhausen", 12).rating(null, 1448).build();
        blackPlayer = Player.builder().playerInfo("Denis", "Graf", "SF Neureut 1953 e.V.", 45).rating(null, 1248).build();
        createGame = new CreateGame();
    }

    @Test
    public void createGameTest() {
        Game game = createGame.createGame(whitePlayer, blackPlayer);
        assertThat(game.getBlackPlayer()).isEqualTo(blackPlayer);
        assertThat(game.getWhitePlayer()).isEqualTo(whitePlayer);
        assertThat(game.getResult()).isEqualTo(null);
    }

}
