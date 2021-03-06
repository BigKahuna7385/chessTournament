package application;

import gui.TournamentGui;
import repositories.GameRepositoryImpl;
import repositories.PlayerRepositoryImpl;
import repositories.RoundRepositoryImpl;

public class ChessTournamentApplication {

    public static void main(String[] args) {
        GameRepositoryImpl gameRepository = new GameRepositoryImpl();
        PlayerRepositoryImpl playerRepository = new PlayerRepositoryImpl();
        RoundRepositoryImpl roundRepository = new RoundRepositoryImpl();

        Tournament tournament = new Tournament(gameRepository, roundRepository, playerRepository);
        tournament.initializeServices();
        new TournamentGui(tournament);
    }
}
