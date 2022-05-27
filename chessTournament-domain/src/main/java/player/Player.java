package player;

import game.Game;

import java.util.Objects;

public class Player implements Comparable<Player> {
    private final PlayerInfo playerInfo;
    private final Rating rating;
    private double score;
    private TournamentRating tournamentRating;
    private final int id;

    public Player(PlayerInfo playerInfo, Rating rating, int id) {
        this.playerInfo = playerInfo;
        this.rating = rating;
        this.id = id;
        score = 0;
    }

    public PlayerInfo getPlayerInfo() {
        return playerInfo;
    }

    public Rating getRating() {
        return rating;
    }

    public int getId() {
        return id;
    }

    public double getScore() {
        return score;
    }

    public TournamentRating getTournamentRating() {
        return tournamentRating;
    }

    public String getFullName() {
        return playerInfo.getName().getFullName();
    }

    public void setTournamentRating(TournamentRating tournamentRating) {
        this.tournamentRating = tournamentRating;
    }

    public static PlayerBuilder builder() {
        return new PlayerBuilder();
    }

    public void addScoreFrom(Game game) {
        if (game.getResult().isDrawn()) {
            score = score + 0.5d;
        } else if (game.getWhitePlayer() == this && game.getResult().hasWhiteWon()) {
            score = score + 1.0d;
        } else if (game.getBlackPlayer() == this && game.getResult().hasBlackWon()) {
            score = score + 1.0d;
        }
    }

    @Override
    public int compareTo(Player o) {
        if (this.getScore() != o.getScore())
            return (int) ((o.getScore() - this.getScore()) * 2);
        if (this.getTournamentRating() != o.getTournamentRating()) {
            if (this.getTournamentRating().getSonnebornBergerScore() != o.getTournamentRating().getSonnebornBergerScore())
                return (int) (o.getTournamentRating().getSonnebornBergerScore() - this.getTournamentRating().getSonnebornBergerScore()) * 4;
            return (int) (o.getTournamentRating().getBuchholzScore() - this.getTournamentRating().getBuchholzScore()) * 4;
        }
        if (this.getRating().getElo() == null || o.getRating().getElo() == null)
            return o.getRating().getDwz().getRatingNumber() - this.getRating().getDwz().getRatingNumber();
        return o.getRating().getElo().getRatingNumber() - this.getRating().getElo().getRatingNumber();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id == player.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerInfo=" + playerInfo +
                ", rating=" + rating +
                ", score=" + score +
                ", tournamentRating=" + tournamentRating +
                ", id=" + id +
                '}';
    }
}
