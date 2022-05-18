package exceptions;

import Player.PlayerInfo;

public class InvalidPlayerInfoException extends Exception {

    public InvalidPlayerInfoException(PlayerInfo playerInfo) {
        super("Invalid player info");
    }
}
