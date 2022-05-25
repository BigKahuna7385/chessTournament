package application.exceptions;

public class TournamentServicesAreNotInitializedException extends Exception {

    public TournamentServicesAreNotInitializedException() {
        super("Some tournament services could not be initialized.\nPlease restart the application.");
    }
}
