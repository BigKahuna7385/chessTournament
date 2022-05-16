package domain.entities;

public class TournamentRating {

    private double buchholzScore;
    private double sonnebornBergerScore;

    public TournamentRating(double buchholzScore, double sonnebornBergerScore) {
        this.buchholzScore = buchholzScore;
        this.sonnebornBergerScore = sonnebornBergerScore;
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
}
