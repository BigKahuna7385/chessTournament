package player;

import exceptions.*;

public class PlayerBuilder {

    private PlayerInfo playerInfo;
    private Rating rating;
    private int id;

    public PlayerBuilder playerInfo(final PlayerInfo playerInfo) {
        this.playerInfo = playerInfo;
        return this;
    }

    public PlayerBuilder playerInfo(final PlayerName playerName, final String clubName, final ListNumber listNumber) throws InvalidPlayerInfoException {
        this.playerInfo = PlayerInfo.builder()
                .playerName(playerName)
                .clubName(clubName)
                .listNumber(listNumber)
                .build();
        return this;
    }

    public PlayerBuilder playerInfo(final String firstName, final String lastName, final String clubName, final ListNumber listNumber) throws InvalidPlayerInfoException, InvalidPlayerNameExeption {
        this.playerInfo = PlayerInfo.builder()
                .playerName(new PlayerName(firstName, lastName))
                .clubName(clubName)
                .listNumber(listNumber)
                .build();
        return this;
    }

    public PlayerBuilder playerInfo(final PlayerName playerName, final String clubName, final int listNumber) throws InvalidPlayerInfoException, InvalidListNumberException {
        this.playerInfo = PlayerInfo.builder()
                .playerName(playerName)
                .clubName(clubName)
                .listNumber(new ListNumber(listNumber))
                .build();
        return this;
    }

    public PlayerBuilder playerInfo(final String firstName, final String lastName, final String clubName, final int listNumber) throws InvalidPlayerInfoException, InvalidListNumberException, InvalidPlayerNameExeption {
        this.playerInfo = PlayerInfo.builder()
                .playerName(new PlayerName(firstName, lastName))
                .clubName(clubName)
                .listNumber(new ListNumber(listNumber))
                .build();
        return this;
    }

    public PlayerBuilder rating(final Rating rating) {
        this.rating = rating;
        return this;
    }

    public PlayerBuilder rating(final RatingNumber elo, final RatingNumber dwz) throws InvalidRatingException {
        this.rating = Rating.builder().dwz(dwz).elo(elo).build();
        return this;
    }

    public PlayerBuilder rating(final int elo, final int dwz) throws InvalidRatingException, InvalidRatingNumberException {
        this.rating = Rating.builder().dwz(dwz).elo(elo).build();
        return this;
    }

    public PlayerBuilder rating(final RatingNumber elo, final int dwz) throws InvalidRatingException, InvalidRatingNumberException {
        this.rating = Rating.builder().dwz(dwz).elo(elo).build();
        return this;
    }

    public PlayerBuilder rating(final int elo, final RatingNumber dwz) throws InvalidRatingException, InvalidRatingNumberException {
        this.rating = Rating.builder().dwz(dwz).elo(elo).build();
        return this;
    }

    public PlayerBuilder id(int id) {
        this.id = id;
        return this;
    }

    public Player build() {
        return new Player(playerInfo, rating, id);
    }
}
