package Player;

import Game.Game;
import Game.ChessResult;
import exceptions.InvalidRatingException;
import exceptions.InvalidRatingNumberException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayerTest {

    @Test
    void createPlayerTest() throws InvalidRatingNumberException, InvalidRatingException {
        PlayerName playerName = mock(PlayerName.class);
        when(playerName.getFirstName()).thenReturn("Daniel");
        when(playerName.getLastName()).thenReturn("Burger");
        when(playerName.getFullName()).thenReturn("Burger, Daniel");

        ListNumber listNumber = mock(ListNumber.class);
        when(listNumber.getListNumber()).thenReturn(12);

        PlayerInfo playerInfo = mock(PlayerInfo.class);
        when(playerInfo.getName()).thenReturn(playerName);
        when(playerInfo.getListNumber()).thenReturn(listNumber);
        when(playerInfo.getClubName()).thenReturn("SF Oberhausen-Rheinhausen");


        Player player = Player.builder().playerInfo(playerInfo).rating(mock(Rating.class)).id(1).build();

        assertAll("player",
                () -> assertEquals("Burger, Daniel", player.getFullName()),
                () -> assertEquals("Daniel", player.getPlayerInfo().getName().getFirstName()),
                () -> assertEquals("Burger", player.getPlayerInfo().getName().getLastName()),
                () -> assertEquals("SF Oberhausen-Rheinhausen", player.getPlayerInfo().getClubName()),
                () -> assertEquals(12, player.getPlayerInfo().getListNumber().getListNumber()));
    }

    @Test
    void twoPlayersAreEqual() {
        PlayerInfo playerInfo = mock(PlayerInfo.class);
        Rating rating = mock(Rating.class);
        Player player1 = Player.builder().playerInfo(playerInfo).rating(rating).build();
        Player player2 = Player.builder().playerInfo(playerInfo).rating(rating).build();
        assertEquals(player1, player2);
    }

    @Test
    void testRatingSortingByElo() {
        RatingNumber ratingNumber1000 = mock(RatingNumber.class);
        when(ratingNumber1000.getRatingNumber()).thenReturn(1000);
        RatingNumber ratingNumber2000 = mock(RatingNumber.class);
        when(ratingNumber2000.getRatingNumber()).thenReturn(2000);

        Rating ratingA = mock(Rating.class);
        when(ratingA.getElo()).thenReturn(ratingNumber1000);
        when(ratingA.getDwz()).thenReturn(ratingNumber2000);
        Rating ratingB = mock(Rating.class);
        when(ratingB.getElo()).thenReturn(ratingNumber2000);
        when(ratingB.getDwz()).thenReturn(ratingNumber1000);

        Player playerA = Player.builder().playerInfo(mock(PlayerInfo.class)).rating(ratingA).build();
        Player playerB = Player.builder().playerInfo(mock(PlayerInfo.class)).rating(ratingB).build();

        List<Player> playerList = new ArrayList<>();

        playerList.add(playerA);
        playerList.add(playerB);

        Collections.sort(playerList);

        assertThat(playerList.get(0)).isEqualTo(playerB);
        assertThat(playerList.get(1)).isEqualTo(playerA);
    }

    @Test
    void testRatingSortingByDwZ() {
        RatingNumber ratingNumber1000 = mock(RatingNumber.class);
        when(ratingNumber1000.getRatingNumber()).thenReturn(1000);
        RatingNumber ratingNumber2000 = mock(RatingNumber.class);
        when(ratingNumber2000.getRatingNumber()).thenReturn(2000);

        Rating ratingA = mock(Rating.class);
        when(ratingA.getElo()).thenReturn(null);
        when(ratingA.getDwz()).thenReturn(ratingNumber2000);
        Rating ratingB = mock(Rating.class);
        when(ratingB.getElo()).thenReturn(ratingNumber2000);
        when(ratingB.getDwz()).thenReturn(ratingNumber1000);

        Player playerA = Player.builder().playerInfo(mock(PlayerInfo.class)).rating(ratingA).build();

        Player playerB = Player.builder().playerInfo(mock(PlayerInfo.class)).rating(ratingB).build();

        List<Player> playerList = new ArrayList<>();

        playerList.add(playerB);
        playerList.add(playerA);

        Collections.sort(playerList);

        assertThat(playerList.get(0)).isEqualTo(playerA);
        assertThat(playerList.get(1)).isEqualTo(playerB);
    }

    @Test
    void testRatingSortingByScore() {
        Player playerA = Player.builder().playerInfo(mock(PlayerInfo.class)).rating(mock(Rating.class)).build();
        Player playerB = Player.builder().playerInfo(mock(PlayerInfo.class)).rating(mock(Rating.class)).build();

        ChessResult chessResultWhiteHasWon = mock(ChessResult.class);
        when(chessResultWhiteHasWon.hasWhiteWon()).thenReturn(true);

        Game gameWhiteWon = mock(Game.class);
        when(gameWhiteWon.getResult()).thenReturn(chessResultWhiteHasWon);
        when(gameWhiteWon.getWhitePlayer()).thenReturn(playerA);

        playerA.addScoreFrom(gameWhiteWon);

        List<Player> playerList = new ArrayList<>();

        playerList.add(playerB);
        playerList.add(playerA);

        Collections.sort(playerList);

        assertThat(playerList.get(0)).isEqualTo(playerA);
        assertThat(playerList.get(1)).isEqualTo(playerB);
    }

    @Test
    void testCorrectGameResultsForPlayer(){

        Player player = Player.builder().playerInfo(mock(PlayerInfo.class)).rating(mock(Rating.class)).build();

        ChessResult whiteHasWon = mock(ChessResult.class);
        when(whiteHasWon.hasWhiteWon()).thenReturn(true);

        ChessResult blackHasWon = mock(ChessResult.class);
        when(blackHasWon.hasBlackWon()).thenReturn(true);

        ChessResult isDrawn = mock(ChessResult.class);
        when(isDrawn.isDrawn()).thenReturn(true);

        Game game1 = mock(Game.class);
        when(game1.getWhitePlayer()).thenReturn(player);
        when(game1.getResult()).thenReturn(whiteHasWon);

        assertThat(player.hasWon(game1)).isEqualTo(true);
        assertThat(player.hasDrawn(game1)).isEqualTo(false);

        Game game2 = mock(Game.class);
        when(game2.getBlackPlayer()).thenReturn(player);
        when(game2.getResult()).thenReturn(blackHasWon);
        assertThat(player.hasWon(game2)).isEqualTo(true);
        assertThat(player.hasDrawn(game2)).isEqualTo(false);


        Game game3 = mock(Game.class);
        when(game3.getBlackPlayer()).thenReturn(player);
        when(game3.getResult()).thenReturn(isDrawn);
        assertThat(player.hasWon(game3)).isEqualTo(false);
        assertThat(player.hasDrawn(game3)).isEqualTo(true);

    }

    @Test
    void testGetOpponentMethod(){
        Player player = Player.builder().playerInfo(mock(PlayerInfo.class)).rating(mock(Rating.class)).build();
        Player opponent = Player.builder().playerInfo(mock(PlayerInfo.class)).rating(mock(Rating.class)).build();

        Game game = mock(Game.class);
        when(game.getWhitePlayer()).thenReturn(player);
        when(game.getBlackPlayer()).thenReturn(opponent);

        assertThat(player.getOpponentIn(game)).isEqualTo(opponent);

        Game rematch = mock(Game.class);
        when(rematch.getWhitePlayer()).thenReturn(opponent);
        when(rematch.getBlackPlayer()).thenReturn(player);

        assertThat(player.getOpponentIn(game)).isEqualTo(opponent);
    }

}
