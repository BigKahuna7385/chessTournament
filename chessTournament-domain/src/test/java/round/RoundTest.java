package round;

import game.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoundTest {
    @Test
    void createNewRoundTest(){
        Game[] games = new Game[8];
        Round round = new Round(games,1);

        assertAll("round",
                ()->assertEquals(round.getGames().length, 8),
                ()-> assertEquals(round.getId(),1));
    }
}
