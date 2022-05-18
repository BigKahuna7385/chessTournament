package Player;

import java.util.Objects;
import java.util.UUID;

public class Player {
    private final PlayerInfo playerInfo;
    private final Rating rating;
    private TournamentRating tournamentRating;
    private final String uuid;

    public Player(PlayerInfo playerInfo, Rating rating) {
        this.playerInfo = playerInfo;
        this.rating = rating;
        this.uuid = UUID.randomUUID().toString();
    }

    public String getFullName() {
        return playerInfo.getName().getFullName();
    }

    public String getUuid() {
        return uuid;
    }

    public TournamentRating getTournamentRating() {
        return tournamentRating;
    }

    public void setTournamentRating(TournamentRating tournamentRating) {
        this.tournamentRating = tournamentRating;
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
