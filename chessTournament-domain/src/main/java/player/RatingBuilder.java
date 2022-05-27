package player;

import exceptions.InvalidRatingException;
import exceptions.InvalidRatingNumberException;

public class RatingBuilder {

    private RatingNumber dwz;
    private RatingNumber elo;

    public Rating build() throws InvalidRatingException {
        return new Rating(elo,dwz);
    }

    public RatingBuilder dwz(RatingNumber dwz){
        this.dwz = dwz;
        return this;
    }

    public RatingBuilder dwz(int dwz) throws InvalidRatingNumberException {
        this.dwz = new RatingNumber(dwz);
        return this;
    }

    public RatingBuilder elo(RatingNumber elo){
        this.elo = elo;
        return this;
    }

    public RatingBuilder elo(int elo) throws InvalidRatingNumberException {
        this.elo = new RatingNumber(elo);
        return this;
    }
}
