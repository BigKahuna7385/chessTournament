package domain.aggregates;

import domain.entities.TournamentRating;
import domain.valueobjects.PlayerInfo;
import domain.valueobjects.PlayerName;
import domain.valueobjects.Rating;

public class Player {
    private final PlayerInfo playerInfo;
    private final Rating rating;
    private final TournamentRating tournamentRating;

    public Player(PlayerInfo playerInfo, Rating rating, TournamentRating tournamentRating) {
        this.playerInfo = playerInfo;
        this.rating = rating;
        this.tournamentRating = tournamentRating;
    }

    public String getFullName() {
        return playerInfo.getName().getFullName();
    }

    public String getClubName() {
        return playerInfo.getClubName();
    }

    public int getEloRating() {
        return rating.getElo().getRatingNumber();
    }

    public int getDwzRating() {
        return rating.getDwz().getRatingNumber();
    }

    public double getBuchholzScore(){
        return tournamentRating.getBuchholzScore();
    }

    public double getSonnebornBergerScore(){
        return tournamentRating.getSonnebornBergerScore();
    }

    public TournamentRating getTournamentRating() {
        return tournamentRating;
    }
}
