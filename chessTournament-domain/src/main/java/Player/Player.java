package Player;

import Game.Game;

import java.util.Objects;
import java.util.UUID;

public class Player implements Comparable<Player> {
    private final PlayerInfo playerInfo;
    private final Rating rating;
    private double score;
    private TournamentRating tournamentRating;
    private final String uuid;

    public Player(PlayerInfo playerInfo, Rating rating) {
        this.playerInfo = playerInfo;
        this.rating = rating;
        this.uuid = UUID.randomUUID().toString();
        score = 0;
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

    public void addScoreFrom(Game game) {
        if (game.getResult().isDrawn()) {
            score = score + 0.5d;
        } else if (game.getWhitePlayer() == this && game.getResult().hasWhiteWon()) {
            score = score + 1.0d;
        } else if (game.getBlackPlayer() == this && game.getResult().hasBlackWon()) {
            score = score + 1.0d;
        }
    }

    public double getScore() {
        return score;
    }

    public boolean hasWon(Game game) {
        if (this == game.getBlackPlayer() && game.getResult().hasBlackWon()) return true;
        else return this == game.getWhitePlayer() && game.getResult().hasWhiteWon();
    }

    public boolean hasDrawn(Game game) {
        if (game.getBlackPlayer() == this || game.getWhitePlayer() == this) return game.getResult().isDrawn();
        return false;
    }

    public Player getOpponentIn(Game game) {
        if (game == null)
            return null;
        if (game.getWhitePlayer() == this)
            return game.getBlackPlayer();
        if (game.getBlackPlayer() == this)
            return game.getWhitePlayer();
        return null;
    }

    @Override
    public int compareTo(Player o) {
        if (this.getScore() != o.getScore())
            return (int) (o.getScore() - this.getScore()) * 2;
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
