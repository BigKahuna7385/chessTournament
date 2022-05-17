package domain.aggregates;

import domain.entities.TournamentRating;
import domain.factories.PlayerFactory;
import domain.valueobjects.PlayerInfo;
import domain.valueobjects.Rating;

import java.util.Objects;

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

    public double getBuchholzScore() {
        return tournamentRating.getBuchholzScore();
    }

    public double getSonnebornBergerScore() {
        return tournamentRating.getSonnebornBergerScore();
    }

    public TournamentRating getTournamentRating() {
        return tournamentRating;
    }

    public static PlayerFactory builder() {
        return new PlayerFactory();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(playerInfo, player.playerInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerInfo);
    }

    public PlayerInfo getPlayerInfo() {
        return playerInfo;
    }

    public Rating getRating() {
        return rating;
    }
}
