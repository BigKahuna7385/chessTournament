package player;

import exceptions.InvalidPlayerInfoException;

public class PlayerInfoBuilder {

    private PlayerName playerName;
    private String clubName;
    private ListNumber listNumber;

    public PlayerInfo build() throws InvalidPlayerInfoException {
        return new PlayerInfo(playerName, clubName, listNumber);
    }

    public PlayerInfoBuilder playerName(PlayerName playerName){
        this.playerName = playerName;
        return this;
    }

    public PlayerInfoBuilder clubName(String clubName){
        this.clubName = clubName;
        return this;
    }

    public PlayerInfoBuilder listNumber(ListNumber listNumber){
        this.listNumber = listNumber;
        return this;
    }

}
