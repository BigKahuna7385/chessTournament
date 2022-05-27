package player;

import game.ChessResult;
import game.Game;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static player.Player.builder;

public class PlayerTest {

    @Test
    void createPlayerTest() {
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


        Player player = builder().playerInfo(playerInfo).rating(mock(Rating.class)).id(1).build();

        assertAll("player",
                () -> assertEquals("Burger, Daniel", player.getFullName()),
                () -> assertEquals("Daniel", player.getPlayerInfo().getName().getFirstName()),
                () -> assertEquals("Burger", player.getPlayerInfo().getName().getLastName()),
                () -> assertEquals("SF Oberhausen-Rheinhausen", player.getPlayerInfo().getClubName()),
                () -> assertEquals(12, player.getPlayerInfo().getListNumber().getListNumber()));
    }

    @Test
    void twoPlayersAreEqualTest() {
        PlayerInfo playerInfo = mock(PlayerInfo.class);
        Rating rating = mock(Rating.class);
        Player player1 = builder().playerInfo(playerInfo).rating(rating).id(0).build();
        Player player2 = builder().playerInfo(playerInfo).rating(rating).id(0).build();
        assertEquals(player1, player2);
    }

    @Test
    void testRatingSortingByElo() {
        Player playerA = setUpPlayerWith(2000, 1000, 0);
        Player playerB = setUpPlayerWith(1000, 2000, 1);

        List<Player> playerList = new ArrayList<>();

        playerList.add(playerA);
        playerList.add(playerB);

        Collections.sort(playerList);

        assertThat(playerList.get(0)).isEqualTo(playerB);
        assertThat(playerList.get(1)).isEqualTo(playerA);
    }

    @Test
    void testRatingSortingByDwZ() {
        Player playerA = setUpPlayerWith(2000, 0, 0);
        Player playerB = setUpPlayerWith(1000, 2000, 1);

        List<Player> playerList = new ArrayList<>();

        playerList.add(playerB);
        playerList.add(playerA);

        Collections.sort(playerList);

        assertThat(playerList.get(0)).isEqualTo(playerA);
        assertThat(playerList.get(1)).isEqualTo(playerB);
    }

    @Test
    void testRatingSortingByScore() {
        Player playerA = setUpPlayer(0);
        Player playerB = setUpPlayer(1);
        Player playerC = setUpPlayerWith(1500, 1500, 2);
        Player playerD = setUpPlayerWith(1000, 1000, 3);

        ChessResult chessResultWhiteHasWon = mock(ChessResult.class);
        when(chessResultWhiteHasWon.hasWhiteWon()).thenReturn(true);
        ChessResult chessResultDraw = mock(ChessResult.class);
        when(chessResultDraw.isDrawn()).thenReturn(true);

        Game gameWhiteWon = mockUpGame(playerA, playerB, chessResultWhiteHasWon);
        Game gameDraw = mockUpGame(playerC, playerD, chessResultDraw);

        playerA.addScoreFrom(gameWhiteWon);
        playerB.addScoreFrom(gameWhiteWon);
        playerC.addScoreFrom(gameDraw);
        playerD.addScoreFrom(gameDraw);

        List<Player> playerList = new ArrayList<>();

        playerList.add(playerD);
        playerList.add(playerB);
        playerList.add(playerC);
        playerList.add(playerA);

        Collections.sort(playerList);

        assertThat(playerList.get(0)).isEqualTo(playerA);
        assertThat(playerList.get(1)).isEqualTo(playerC);
        assertThat(playerList.get(2)).isEqualTo(playerD);
        assertThat(playerList.get(3)).isEqualTo(playerB);
    }

    Player setUpPlayer(int id) {
        return builder().playerInfo(mock(PlayerInfo.class)).rating(mock(Rating.class)).id(id).build();
    }

    Player setUpPlayerWith(int dwz, int elo, int id) {
        RatingNumber ratingNumberDwz = mock(RatingNumber.class);
        when(ratingNumberDwz.getRatingNumber()).thenReturn(dwz);
        RatingNumber ratingNumberElo = mock(RatingNumber.class);
        when(ratingNumberElo.getRatingNumber()).thenReturn(elo);
        Rating rating = mock(Rating.class);
        if (dwz > 0)
            when(rating.getDwz()).thenReturn(ratingNumberDwz);
        if (elo > 0)
            when(rating.getElo()).thenReturn(ratingNumberElo);

        return builder().playerInfo(mock(PlayerInfo.class)).rating(rating).id(id).build();
    }

    Game mockUpGame(Player whitePlayer, Player blackPlayer, ChessResult result) {
        Game game = mock(Game.class);
        when(game.getResult()).thenReturn(result);
        when(game.getWhitePlayer()).thenReturn(whitePlayer);
        when(game.getBlackPlayer()).thenReturn(blackPlayer);
        return game;
    }

}
