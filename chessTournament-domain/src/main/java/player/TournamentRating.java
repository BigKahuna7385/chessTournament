package player;

import java.util.Objects;

public class TournamentRating {

    private final double buchholzScore;
    private final double sonnebornBergerScore;

    public TournamentRating(double buchholzScore, double sonnebornBergerScore) {
        this.buchholzScore = buchholzScore;
        this.sonnebornBergerScore = sonnebornBergerScore;
    }

    public double getBuchholzScore() {
        return buchholzScore;
    }

    public double getSonnebornBergerScore() {
        return sonnebornBergerScore;
    }

    public static TournamentRatingCalculator calculateTournamentRating() {
        return new TournamentRatingCalculator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TournamentRating that = (TournamentRating) o;
        return Double.compare(that.buchholzScore, buchholzScore) == 0 && Double.compare(that.sonnebornBergerScore, sonnebornBergerScore) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(buchholzScore, sonnebornBergerScore);
    }
}
