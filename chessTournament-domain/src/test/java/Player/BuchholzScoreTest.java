package Player;

import Game.Game;
import Game.ChessResult;
import exceptions.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BuchholzScoreTest {

    @Test
    void testSonnebornBergerScore() throws InvalidRatingException, InvalidRatingNumberException, InvalidListNumberException, InvalidPlayerInfoException, InvalidPlayerNameExeption, InvalidResultException {
        Rating rating = new Rating(new RatingNumber(1500), new RatingNumber(1500));
        Player playerA = Player.builder().playerInfo("Player", "A", "Club A", 1).rating(rating).build();
        Player playerB = Player.builder().playerInfo("Player", "B", "Club A", 2).rating(rating).build();
        Player playerC = Player.builder().playerInfo("Player", "C", "Club A", 3).rating(rating).build();
        Player playerD = Player.builder().playerInfo("Player", "D", "Club A", 4).rating(rating).build();
        Player playerE = Player.builder().playerInfo("Player", "E", "Club A", 5).rating(rating).build();
        Player playerF = Player.builder().playerInfo("Player", "F", "Club A", 6).rating(rating).build();
        Player playerG = Player.builder().playerInfo("Player", "G", "Club A", 7).rating(rating).build();

        Game[] games = new Game[21];
        ChessResult whiteWins = new ChessResult(true, false, false);
        ChessResult draw = new ChessResult(false, false, true);

        games[0] = new Game(playerA, playerB,0);
        games[0].setResult(draw);

        games[1] = new Game(playerA, playerC,1);
        games[1].setResult(draw);

        games[2] = new Game(playerA, playerD,2);
        games[2].setResult(whiteWins);

        games[3] = new Game(playerA, playerE,3);
        games[3].setResult(whiteWins);

        games[4] = new Game(playerA, playerF,4);
        games[4].setResult(whiteWins);

        games[5] = new Game(playerA, playerG,5);
        games[5].setResult(whiteWins);

        games[6] = new Game(playerB, playerC,6);
        games[6].setResult(draw);

        games[7] = new Game(playerB, playerD,7);
        games[7].setResult(draw);

        games[8] = new Game(playerB, playerE,8);
        games[8].setResult(whiteWins);

        games[9] = new Game(playerB, playerF,9);
        games[9].setResult(whiteWins);

        games[10] = new Game(playerB, playerG,10);
        games[10].setResult(whiteWins);

        games[11] = new Game(playerC, playerD,11);
        games[11].setResult(draw);

        games[12] = new Game(playerC, playerE,12);
        games[12].setResult(draw);

        games[13] = new Game(playerC, playerF,13);
        games[13].setResult(whiteWins);

        games[14] = new Game(playerC, playerG,14);
        games[14].setResult(whiteWins);

        games[15] = new Game(playerD, playerE,15);
        games[15].setResult(whiteWins);

        games[16] = new Game(playerD, playerF,16);
        games[16].setResult(whiteWins);

        games[17] = new Game(playerD, playerG,17);
        games[17].setResult(whiteWins);

        games[18] = new Game(playerE, playerF,18);
        games[18].setResult(whiteWins);

        games[19] = new Game(playerE, playerG,19);
        games[19].setResult(whiteWins);

        games[20] = new Game(playerF, playerG,20);
        games[20].setResult(whiteWins);

        assertThat(playerA.getScore()).isEqualTo(5d);
        assertThat(playerB.getScore()).isEqualTo(4.5d);
        assertThat(playerC.getScore()).isEqualTo(4d);
        assertThat(playerD.getScore()).isEqualTo(4d);
        assertThat(playerE.getScore()).isEqualTo(2.5d);
        assertThat(playerF.getScore()).isEqualTo(1d);
        assertThat(playerG.getScore()).isEqualTo(0d);

        playerA.setTournamentRating(TournamentRating.calculateTournamentRating().player(playerA).games(games).calculate());
        playerB.setTournamentRating(TournamentRating.calculateTournamentRating().player(playerB).games(games).calculate());

        assertThat(playerA.getTournamentRating().getBuchholzScore()).isEqualTo(16d);
        assertThat(playerB.getTournamentRating().getBuchholzScore()).isEqualTo(16.5d);

        //https://de.wikipedia.org/wiki/Feinwertung#Einzelwertungen

    }

}
