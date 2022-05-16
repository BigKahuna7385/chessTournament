package domain.valueobjects;

import domain.exceptions.InvalidRatingNumberException;

public class RatingNumber {

    private final int ratingNumber;

    public RatingNumber(int ratingNumber) throws InvalidRatingNumberException {
        this.ratingNumber = ratingNumber;
        if (this.ratingNumber <= 0)
            throw new InvalidRatingNumberException();
    }

    public int getRatingNumber() {
        return ratingNumber;
    }
}
