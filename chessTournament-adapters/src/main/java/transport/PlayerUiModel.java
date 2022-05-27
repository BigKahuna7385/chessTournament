package transport;

public class PlayerUiModel {
    private final String firstName;
    private final String lastName;
    private final String clubName;
    private final int listNumber;
    private final int elo;
    private final int dwz;
    private final int id;
    private final double score;
    private final double buchholzScore;
    private final double sonnebornBergerScore;

    public PlayerUiModel(String firstName, String lastName, String clubName, int listNumber, int elo, int dwz, int id,
                         double score, double buchholzScore, double sonnebornBergerScore) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.clubName = clubName;
        this.listNumber = listNumber;
        this.elo = elo;
        this.dwz = dwz;
        this.id = id;
        this.score = score;
        this.buchholzScore = buchholzScore;
        this.sonnebornBergerScore = sonnebornBergerScore;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getClubName() {
        return clubName;
    }

    public int getListNumber() {
        return listNumber;
    }

    public int getElo() {
        return elo;
    }

    public int getDwz() {
        return dwz;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    @Override
    public String toString() {
        return "" + firstName + " " + lastName + " " + clubName + " " + elo + " " + dwz;
    }

    public double getScore() {
        return score;
    }

    public double getBuchholzScore() {
        return buchholzScore;
    }

    public double getSonnebornBergerScore() {
        return sonnebornBergerScore;
    }
}
