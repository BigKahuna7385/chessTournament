package Player;

import Game.Game;
import Game.ChessResult;
import exceptions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TournamentRatingTest {

    private Player playerA;
    private Player playerB;
    private Player playerC;
    private Player playerD;
    private Player playerE;
    private Player playerF;
    private Player playerG;

    private ChessResult whiteWins;
    private ChessResult draw;

    private Game[] games;


    @BeforeEach
    void init() {
        setupPlayers();
        setupGameResults();
        setupGames();
    }

    void setupPlayers() {

        playerA = Player.builder().playerInfo(mock(PlayerInfo.class)).rating(mock(Rating.class)).id(1).build();
        playerB = Player.builder().playerInfo(mock(PlayerInfo.class)).rating(mock(Rating.class)).id(2).build();
        playerC = Player.builder().playerInfo(mock(PlayerInfo.class)).rating(mock(Rating.class)).id(3).build();
        playerD = Player.builder().playerInfo(mock(PlayerInfo.class)).rating(mock(Rating.class)).id(4).build();
        playerE = Player.builder().playerInfo(mock(PlayerInfo.class)).rating(mock(Rating.class)).id(5).build();
        playerF = Player.builder().playerInfo(mock(PlayerInfo.class)).rating(mock(Rating.class)).id(6).build();
        playerG = Player.builder().playerInfo(mock(PlayerInfo.class)).rating(mock(Rating.class)).id(7).build();

    }

    void setupGameResults() {
        whiteWins = mock(ChessResult.class);
        when(whiteWins.hasWhiteWon()).thenReturn(true);
        draw = mock(ChessResult.class);
        when(draw.isDrawn()).thenReturn(true);
    }

    void setupGames() {
        games = new Game[21];
        games[0] = mockUpGame(playerA, playerB, draw);
        games[1] = mockUpGame(playerA, playerC, draw);
        games[2] = mockUpGame(playerA, playerD, whiteWins);
        games[3] = mockUpGame(playerA, playerE, whiteWins);
        games[4] = mockUpGame(playerA, playerF, whiteWins);
        games[5] = mockUpGame(playerA, playerG, whiteWins);
        games[6] = mockUpGame(playerB, playerC, draw);
        games[7] = mockUpGame(playerB, playerD, draw);
        games[8] = mockUpGame(playerB, playerE, whiteWins);
        games[9] = mockUpGame(playerB, playerF, whiteWins);
        games[10] = mockUpGame(playerB, playerG, whiteWins);
        games[11] = mockUpGame(playerC, playerD, draw);
        games[12] = mockUpGame(playerC, playerE, draw);
        games[13] = mockUpGame(playerC, playerF, whiteWins);
        games[14] = mockUpGame(playerC, playerG, whiteWins);
        games[15] = mockUpGame(playerD, playerE, whiteWins);
        games[16] = mockUpGame(playerD, playerF, whiteWins);
        games[17] = mockUpGame(playerD, playerG, whiteWins);
        games[18] = mockUpGame(playerE, playerF, whiteWins);
        games[19] = mockUpGame(playerE, playerG, whiteWins);
        games[20] = mockUpGame(playerF, playerG, whiteWins);
    }

    Game mockUpGame(Player playerWhite, Player playerBlack, ChessResult result) {
        Game game = mock(Game.class);
        when(game.getWhitePlayer()).thenReturn(playerWhite);
        when(game.getBlackPlayer()).thenReturn(playerBlack);
        when(game.getResult()).thenReturn(result);
        playerWhite.addScoreFrom(game);
        playerBlack.addScoreFrom(game);
        return game;
    }

    @Test
    void testSonnebornBergerScore() {
        assertThat(playerA.getScore()).isEqualTo(5d);
        assertThat(playerB.getScore()).isEqualTo(4.5d);
        assertThat(playerC.getScore()).isEqualTo(4d);
        assertThat(playerD.getScore()).isEqualTo(4d);
        assertThat(playerE.getScore()).isEqualTo(2.5d);
        assertThat(playerF.getScore()).isEqualTo(1d);
        assertThat(playerG.getScore()).isEqualTo(0d);

        playerC.setTournamentRating(TournamentRating.calculateTournamentRating().player(playerC).games(games).calculate());
        playerD.setTournamentRating(TournamentRating.calculateTournamentRating().player(playerD).games(games).calculate());

        assertThat(playerC.getTournamentRating().getSonnebornBergerScore()).isEqualTo(9.0d);
        assertThat(playerD.getTournamentRating().getSonnebornBergerScore()).isEqualTo(7.75d);

        //https://de.wikipedia.org/wiki/Feinwertung#Einzelwertungen

    }

}