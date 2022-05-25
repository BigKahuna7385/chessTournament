package application.exceptions;

public class PlayerNotRegisteredException extends Exception {

    public PlayerNotRegisteredException() {
        super("A player of a game is not registered in the tournament.");
    }
}
