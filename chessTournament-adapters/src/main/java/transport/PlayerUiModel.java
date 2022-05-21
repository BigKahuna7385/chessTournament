package transport;

public class PlayerUiModel {
    private final String firstName;
    private final String lastName;
    private final String clubName;
    private final int listNumber;
    private final int elo;
    private final int dwz;
    private final int id;

    public PlayerUiModel(String firstName, String lastName, String clubName, int listNumber, int elo, int dwz, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.clubName = clubName;
        this.listNumber = listNumber;
        this.elo = elo;
        this.dwz = dwz;
        this.id = id;
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
}
