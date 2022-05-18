package Player;

import exceptions.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    @Test
    void createPlayerTest() throws InvalidListNumberException, InvalidPlayerInfoException, InvalidPlayerNameExeption, InvalidRatingNumberException, InvalidRatingException {
        Player player = Player.builder().playerInfo("Daniel", "Burger", "SF Oberhausen-Rheinhausen", 12).rating(null, 1448).build();

        assertAll("player",
                () -> assertEquals("Burger, Daniel", player.getFullName()),
                () -> assertEquals("Daniel", player.getPlayerInfo().getName().getFirstName()),
                () -> assertEquals("Burger", player.getPlayerInfo().getName().getLastName()),
                () -> assertEquals("SF Oberhausen-Rheinhausen", player.getPlayerInfo().getClubName()),
                () -> assertEquals(12, player.getPlayerInfo().getListNumber().getListNumber()));
    }

    @Test
    void twoPlayersAreEqual() throws InvalidListNumberException, InvalidPlayerInfoException, InvalidPlayerNameExeption, InvalidRatingNumberException, InvalidRatingException {
        Player player1 = Player.builder().playerInfo("Daniel", "Burger", "SF Oberhausen-Rheinhausen", 12).rating(null, 1448).build();
        Player player2 = Player.builder().playerInfo("Daniel", "Burger", "SF Oberhausen-Rheinhausen", 12).rating(null, 1448).build();

        assertEquals(player1, player2);

    }

    @Test
    void invalidPlayerName() {
        try {
            Player.builder().playerInfo("Daniel", null, "SF Oberhausen-Rheinhausen", 12).rating(null, 1448).build();
        } catch (InvalidRatingException | InvalidRatingNumberException | InvalidPlayerInfoException |
                 InvalidListNumberException e) {
            throw new RuntimeException(e);
        } catch (InvalidPlayerNameExeption exeption) {
            assertThat(exeption.getMessage().equals("Invalid player name"));
        }
    }



}
