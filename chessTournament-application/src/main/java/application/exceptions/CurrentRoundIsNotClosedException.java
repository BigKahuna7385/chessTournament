package application.exceptions;

public class CurrentRoundIsNotClosedException extends Throwable {

    public CurrentRoundIsNotClosedException() {
        super("The current round is still running.");
    }
}
