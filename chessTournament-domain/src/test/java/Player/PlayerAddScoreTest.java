package Player;

import Game.ChessResult;
import Game.Game;
import exceptions.InvalidRatingException;
import exceptions.InvalidRatingNumberException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayerAddScoreTest {

    private Player playerA;
    private Player playerB;
    private Player playerC;
    private Player playerD;
    private Player playerE;
    private Player playerF;
    private Player playerG;

    private ChessResult whiteWins;
    private ChessResult draw;

    @BeforeEach
    void init() {
        setupPlayers();
        setupGameResults();
        setupGames();
    }

    void setupPlayers() {
        try {
            playerA = Player.builder().playerInfo(mock(PlayerInfo.class)).rating(mock(Rating.class)).id(1).build();
            playerB = Player.builder().playerInfo(mock(PlayerInfo.class)).rating(mock(Rating.class)).id(2).build();
            playerC = Player.builder().playerInfo(mock(PlayerInfo.class)).rating(mock(Rating.class)).id(3).build();
            playerD = Player.builder().playerInfo(mock(PlayerInfo.class)).rating(mock(Rating.class)).id(4).build();
            playerE = Player.builder().playerInfo(mock(PlayerInfo.class)).rating(mock(Rating.class)).id(5).build();
            playerF = Player.builder().playerInfo(mock(PlayerInfo.class)).rating(mock(Rating.class)).id(6).build();
            playerG = Player.builder().playerInfo(mock(PlayerInfo.class)).rating(mock(Rating.class)).id(7).build();
        } catch (InvalidRatingException | InvalidRatingNumberException e) {
            throw new RuntimeException(e);
        }
    }

    void setupGameResults() {
        whiteWins = mock(ChessResult.class);
        when(whiteWins.hasWhiteWon()).thenReturn(true);
        draw = mock(ChessResult.class);
        when(draw.isDrawn()).thenReturn(true);
    }

    void setupGames() {
        mockUpGame(playerA, playerB, draw);
        mockUpGame(playerA, playerC, draw);
        mockUpGame(playerA, playerD, whiteWins);
        mockUpGame(playerA, playerE, whiteWins);
        mockUpGame(playerA, playerF, whiteWins);
        mockUpGame(playerA, playerG, whiteWins);
        mockUpGame(playerB, playerC, draw);
        mockUpGame(playerB, playerD, draw);
        mockUpGame(playerB, playerE, whiteWins);
        mockUpGame(playerB, playerF, whiteWins);
        mockUpGame(playerB, playerG, whiteWins);
        mockUpGame(playerC, playerD, draw);
        mockUpGame(playerC, playerE, draw);
        mockUpGame(playerC, playerF, whiteWins);
        mockUpGame(playerC, playerG, whiteWins);
        mockUpGame(playerD, playerE, whiteWins);
        mockUpGame(playerD, playerF, whiteWins);
        mockUpGame(playerD, playerG, whiteWins);
        mockUpGame(playerE, playerF, whiteWins);
        mockUpGame(playerE, playerG, whiteWins);
        mockUpGame(playerF, playerG, whiteWins);
    }

    void mockUpGame(Player playerWhite, Player playerBlack, ChessResult result) {
        Game game = mock(Game.class);
        when(game.getWhitePlayer()).thenReturn(playerWhite);
        when(game.getBlackPlayer()).thenReturn(playerBlack);
        when(game.getResult()).thenReturn(result);
        playerWhite.addScoreFrom(game);
        playerBlack.addScoreFrom(game);
    }

    @Test
    void testAddScore() {
        assertThat(playerA.getScore()).isEqualTo(5d);
        assertThat(playerB.getScore()).isEqualTo(4.5d);
        assertThat(playerC.getScore()).isEqualTo(4d);
        assertThat(playerD.getScore()).isEqualTo(4d);
        assertThat(playerE.getScore()).isEqualTo(2.5d);
        assertThat(playerF.getScore()).isEqualTo(1d);
        assertThat(playerG.getScore()).isEqualTo(0d);
    }

}
