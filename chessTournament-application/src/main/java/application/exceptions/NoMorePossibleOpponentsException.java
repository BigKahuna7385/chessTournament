package application.exceptions;

public class NoMorePossibleOpponentsException extends Exception {

    public NoMorePossibleOpponentsException() {
        super("Not possible to create new pairings. Tournament over?");
    }
}
