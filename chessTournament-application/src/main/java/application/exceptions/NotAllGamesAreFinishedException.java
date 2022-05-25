package application.exceptions;

public class NotAllGamesAreFinishedException extends Exception {

    public NotAllGamesAreFinishedException() {
        super("Not all games in this round are finished, yet.");
    }
    
}
