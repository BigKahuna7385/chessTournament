package domain.exceptions;

import domain.valueobjects.PlayerInfo;

public class InvalidPlayerInfoException extends Exception {

    public InvalidPlayerInfoException(PlayerInfo playerInfo) {
        super("Playerinfo Fehlerhaft");
        System.err.println("Nachname fehlt");
    }
}
