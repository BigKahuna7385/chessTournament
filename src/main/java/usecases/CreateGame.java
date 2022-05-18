package usecases;

import domain.aggregates.Player;
import domain.entities.Game;

public class CreateGame {

    public Game createGame(Player playerWhite, Player playerBlack){
        return new Game(playerWhite,playerBlack);
    }

}
