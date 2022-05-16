package domain.valueobjects;

import java.util.Objects;

public final class Playerinfo {

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

    @Override
    public int hashCode() {
        return Integer.getInteger("" + name.hashCode() + clubName.hashCode() + listNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Playerinfo playerinfo = (Playerinfo) obj;
        return getName().equals(playerinfo.getName()) && getClubName().equals(playerinfo.getClubName()) && getListNumber() == playerinfo.getListNumber();
    }
}
