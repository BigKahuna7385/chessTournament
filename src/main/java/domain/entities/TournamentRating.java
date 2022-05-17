package domain.entities;

import java.util.Objects;
import java.util.UUID;

public class TournamentRating {

    private double buchholzScore;
    private double sonnebornBergerScore;

    private final UUID id;

    public TournamentRating(double buchholzScore, double sonnebornBergerScore) {
        this.buchholzScore = buchholzScore;
        this.sonnebornBergerScore = sonnebornBergerScore;
        this.id = UUID.randomUUID();
    }

    public double getBuchholzScore() {
        return buchholzScore;
    }

    public void setBuchholzScore(double buchholzScore) {
        this.buchholzScore = buchholzScore;
    }

    public double getSonnebornBergerScore() {
        return sonnebornBergerScore;
    }

    public void setSonnebornBergerScore(double sonnebornBergerScore) {
        this.sonnebornBergerScore = sonnebornBergerScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TournamentRating that = (TournamentRating) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
