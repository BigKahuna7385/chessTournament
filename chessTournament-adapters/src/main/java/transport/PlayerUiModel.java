package transport;

public class PlayerUiModel {
    private final String firstName;
    private final String lastName;
    private final String clubName;
    private final int listNumber;
    private final int elo;
    private final int dwz;

    public PlayerUiModel(String firstName, String lastName, String clubName, int listNumber, int elo, int dwz) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.clubName = clubName;
        this.listNumber = listNumber;
        this.elo = elo;
        this.dwz = dwz;
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

    @Override
    public String toString() {
        return "" + firstName + " " + lastName + " " + clubName + " " + elo + " " + dwz;
    }
}
