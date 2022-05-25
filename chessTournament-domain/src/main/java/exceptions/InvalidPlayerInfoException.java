package exceptions;

import player.PlayerInfo;

public class InvalidPlayerInfoException extends Exception {

    public InvalidPlayerInfoException(PlayerInfo playerInfo) {
        super("Invalid player info");
    }
}
