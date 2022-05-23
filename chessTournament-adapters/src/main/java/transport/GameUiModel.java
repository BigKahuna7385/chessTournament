package transport;

public class GameUiModel {

    private final int id;
    private final String whitePlayer;
    private final String blackPlayer;
    private final String score;

    public GameUiModel(int id, String whitePlayer, String blackPlayer, String score) {
        this.id = id;
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public String getWhitePlayer() {
        return whitePlayer;
    }

    public String getBlackPlayer() {
        return blackPlayer;
    }

    public String getScore() {
        return score;
    }
}
