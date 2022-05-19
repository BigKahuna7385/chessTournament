package Player;

import Game.Game;
import Game.ChessResult;
import exceptions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RatingCompareTest {

    @Test
    void testRatingSortingByElo() throws InvalidRatingNumberException, InvalidListNumberException, InvalidPlayerInfoException, InvalidPlayerNameExeption {

        Rating ratingA = new Rating(1000, 2000);
        Rating ratingB = new Rating(2000, 1000);

        Player playerA = Player.builder().playerInfo("Player", "A", "Club", 1).rating(ratingA).build();
        Player playerB = Player.builder().playerInfo("Player", "B", "Club", 1).rating(ratingB).build();

        List<Player> playerList = new ArrayList<>();

        playerList.add(playerA);
        playerList.add(playerB);

        Collections.sort(playerList);

        assertThat(playerList.get(0)).isEqualTo(playerB);
        assertThat(playerList.get(1)).isEqualTo(playerA);

    }

    @Test
    void testRatingSortingByDwZ() throws InvalidRatingNumberException, InvalidListNumberException, InvalidPlayerInfoException, InvalidPlayerNameExeption, InvalidRatingException {

        Rating ratingA = new Rating(null, new RatingNumber(2000));
        Rating ratingB = new Rating(2000, 1000);

        Player playerA = Player.builder().playerInfo("Player", "A", "Club", 1).rating(ratingA).build();
        Player playerB = Player.builder().playerInfo("Player", "B", "Club", 1).rating(ratingB).build();

        List<Player> playerList = new ArrayList<>();

        playerList.add(playerB);
        playerList.add(playerA);

        Collections.sort(playerList);

        assertThat(playerList.get(0)).isEqualTo(playerA);
        assertThat(playerList.get(1)).isEqualTo(playerB);

    }

    @Test
    void testRatingSortingByScore() throws InvalidRatingNumberException, InvalidListNumberException, InvalidPlayerInfoException, InvalidPlayerNameExeption, InvalidResultException {

        Rating ratingA = new Rating(1000, 2000);
        Rating ratingB = new Rating(2000, 1000);

        Player playerA = Player.builder().playerInfo("Player", "A", "Club", 1).rating(ratingA).build();
        Player playerB = Player.builder().playerInfo("Player", "B", "Club", 1).rating(ratingB).build();

        Game game = new Game(playerA, playerB);
        game.setResult(new ChessResult(true, false, false));

        List<Player> playerList = new ArrayList<>();

        playerList.add(playerB);
        playerList.add(playerA);

        Collections.sort(playerList);

        assertThat(playerList.get(0)).isEqualTo(playerA);
        assertThat(playerList.get(1)).isEqualTo(playerB);

    }

}