package usecases;

import domain.aggregates.Player;
import domain.entities.TournamentRating;
import domain.valueobjects.PlayerInfo;
import domain.valueobjects.Rating;

public class CreatePlayer {

    public Player createPlayer(PlayerInfo playerInfo, Rating rating, TournamentRating tournamentRating){
        return new Player(playerInfo,rating,tournamentRating);
    }

}
