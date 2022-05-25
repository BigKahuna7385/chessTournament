package application;

import application.exceptions.PlayerAlreadyRegistered;
import exceptions.*;
import gui.TournamentGui;
import player.Player;
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
        setUpPlayers(tournament);
        new TournamentGui(tournament);
    }

    private static void setUpPlayers(Tournament tournament){
        try {
            tournament.getPlayerService().createNewPlayer(Player.builder().playerInfo("Daniel","14","SF Oberhausen-Rheinhausen",12).rating(1448,1448).id(1).build());
            tournament.getPlayerService().createNewPlayer(Player.builder().playerInfo("Daniel","15","SF Oberhausen-Rheinhausen",12).rating(1448,1548).id(2).build());
            tournament.getPlayerService().createNewPlayer(Player.builder().playerInfo("Daniel","16","SF Oberhausen-Rheinhausen",12).rating(1448,1648).id(3).build());
            tournament.getPlayerService().createNewPlayer(Player.builder().playerInfo("Daniel","17","SF Oberhausen-Rheinhausen",12).rating(1448,1748).id(4).build());
        } catch (PlayerAlreadyRegistered | InvalidRatingException | InvalidRatingNumberException |
                 InvalidPlayerInfoException | InvalidListNumberException | InvalidPlayerNameExeption e) {
            throw new RuntimeException(e);
        }

    }
}
