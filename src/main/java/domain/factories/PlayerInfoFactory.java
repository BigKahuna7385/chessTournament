package domain.factories;

import domain.exceptions.InvalidPlayerInfoException;
import domain.valueobjects.ListNumber;
import domain.valueobjects.PlayerInfo;
import domain.valueobjects.PlayerName;

public class PlayerInfoFactory {

    private PlayerName playerName;
    private String clubName;
    private ListNumber listNumber;

    public PlayerInfoFactory() {
    }

    public PlayerInfo build() throws InvalidPlayerInfoException {
        return new PlayerInfo(playerName, clubName, listNumber);
    }

    public PlayerInfoFactory playerName(PlayerName playerName){
        this.playerName = playerName;
        return this;
    }

    public PlayerInfoFactory clubName(String clubName){
        this.clubName = clubName;
        return this;
    }

    public PlayerInfoFactory listNumber(ListNumber listNumber){
        this.listNumber = listNumber;
        return this;
    }


}
