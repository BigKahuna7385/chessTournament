package exceptions;

public class GameAlreadyAddedException extends Exception {

    public GameAlreadyAddedException() {
        super("Game already in repository");
    }
}
