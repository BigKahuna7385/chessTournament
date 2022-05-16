package domain.valueobjects;

public class Playerinfo {

    private final Name name;
    private final String clubName;
    private final int listNumber;

    public Playerinfo(Name name, String clubName, int listNumber) {
        this.name = name;
        this.clubName = clubName;
        this.listNumber = listNumber;
    }

    public Name getName() {
        return name;
    }

    public String getClubName() {
        return clubName;
    }

    public int getListNumber() {
        return listNumber;
    }
}
