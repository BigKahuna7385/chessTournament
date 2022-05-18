package exceptions;

public class PlayerAlreadyRegistered extends Exception {
    public PlayerAlreadyRegistered() {
        super("Player is already registered");
    }
}
