package domain.factories;

import domain.exceptions.InvalidRatingException;
import domain.exceptions.InvalidRatingNumberException;
import domain.valueobjects.Rating;
import domain.valueobjects.RatingNumber;

public class RatingFactory {

    private RatingNumber dwz;
    private RatingNumber elo;

    public RatingFactory() {
    }

    public Rating build() throws InvalidRatingException {
        return new Rating(elo,dwz);
    }

    public RatingFactory dwz(RatingNumber dwz){
        this.dwz = dwz;
        return this;
    }

    public RatingFactory dwz(int dwz) throws InvalidRatingNumberException {
        this.dwz = new RatingNumber(dwz);
        return this;
    }

    public RatingFactory elo(RatingNumber elo){
        this.elo = elo;
        return this;
    }

    public RatingFactory elo(int elo) throws InvalidRatingNumberException {
        this.elo = new RatingNumber(elo);
        return this;
    }
}
