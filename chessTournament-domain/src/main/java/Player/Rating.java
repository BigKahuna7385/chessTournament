package Player;

import exceptions.InvalidRatingException;

import java.util.Objects;

public final class Rating {
     final RatingNumber elo;
     final RatingNumber dwz;

    public Rating(RatingNumber elo, RatingNumber dwz) throws InvalidRatingException {
        this.elo = elo;
        this.dwz = dwz;
        if (this.dwz == null)
            throw new InvalidRatingException();
    }

    public RatingNumber getElo() {
        return elo;
    }

    public RatingNumber getDwz() {
        return dwz;
    }

    public static RatingFactory builder(){
        return new RatingFactory();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating = (Rating) o;
        return Objects.equals(elo, rating.elo) && dwz.equals(rating.dwz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elo, dwz);
    }
}
