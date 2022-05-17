package domain.valueobjects;

import domain.exceptions.InvalidRatingNumberException;

import java.util.Objects;

public final class RatingNumber {

    final int ratingNumber;

    public RatingNumber(int ratingNumber) throws InvalidRatingNumberException {
        this.ratingNumber = ratingNumber;
        if (this.ratingNumber <= 0)
            throw new InvalidRatingNumberException();
    }

    public int getRatingNumber() {
        return ratingNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RatingNumber that = (RatingNumber) o;
        return ratingNumber == that.ratingNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ratingNumber);
    }
}
