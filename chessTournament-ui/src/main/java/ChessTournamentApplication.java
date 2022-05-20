
import application.Tournament;
import gui.TournamentGui;
import persistance.GameRepositoryImpl;
import persistance.PlayerRepositoryImpl;
import persistance.RoundRepositoryImpl;

import javax.swing.*;

public class ChessTournamentApplication {

    public static void main(String[] args) {
        GameRepositoryImpl gameRepository = new GameRepositoryImpl();
        PlayerRepositoryImpl playerRepository = new PlayerRepositoryImpl();
        RoundRepositoryImpl roundRepository = new RoundRepositoryImpl();

        Tournament tournament = new Tournament(gameRepository,roundRepository,playerRepository);
        JFrame chessTournament = new TournamentGui(tournament);
        chessTournament.setVisible(true);

    }
}
