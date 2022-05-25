package exceptions;

import player.PlayerInfo;

public class InvalidPlayerInfoException extends Exception {

    public InvalidPlayerInfoException() {
        super("Invalid player info");
    }
}
