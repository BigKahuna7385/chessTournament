package Player;

import exceptions.InvalidPlayerInfoException;

import java.util.Objects;

public final class PlayerInfo {

     final PlayerName name;
     final String clubName;
     final ListNumber listNumber;

    public PlayerInfo(PlayerName name, String clubName, ListNumber listNumber) throws InvalidPlayerInfoException {
        this.name = name;
        this.clubName = clubName;
        this.listNumber = listNumber;
        if (this.name == null || this.clubName == null || this.listNumber == null)
            throw new InvalidPlayerInfoException(this);
    }

    public static PlayerInfoFactory builder(){
        return new PlayerInfoFactory();
    }

    public PlayerName getName() {
        return name;
    }

    public String getClubName() {
        return clubName;
    }

    public ListNumber getListNumber() {
        return listNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerInfo that = (PlayerInfo) o;
        return name.equals(that.name) && clubName.equals(that.clubName) && listNumber.equals(that.listNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, clubName, listNumber);
    }
}
