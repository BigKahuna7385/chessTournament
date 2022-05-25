package game;

import player.Player;

import java.util.List;
import java.util.Objects;

public class Game {

    private final Player whitePlayer;
    private final Player blackPlayer;
    private int id;
    private ChessResult chessResult;

    public Game(Player whitePlayer, Player blackPlayer, int id) {
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        this.id = id;
    }

    public void setResult(ChessResult chessResult) {
        this.chessResult = chessResult;
        addResultToPlayerScores();
    }

    private void addResultToPlayerScores() {
        whitePlayer.addScoreFrom(this);
        blackPlayer.addScoreFrom(this);
    }

    public String getScoreOf(Player player) {
        if (chessResult == null) return "";
        if (chessResult.isDrawn()) return "½";
        if (player == blackPlayer && chessResult.hasBlackWon() || player == whitePlayer && chessResult.hasWhiteWon()) {
            return "1";
        }
        return "0";
    }

    public Player getWhitePlayer() {
        return whitePlayer;
    }

    public Player getBlackPlayer() {
        return blackPlayer;
    }

    public ChessResult getResult() {
        return chessResult;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return getBlackPlayer() == game.getBlackPlayer() && getWhitePlayer() == game.getWhitePlayer()
                || getWhitePlayer() == game.getBlackPlayer() && getBlackPlayer() == game.getWhitePlayer();
    }

    @Override
    public int hashCode() {
        Player player1 = blackPlayer.getId() < whitePlayer.getId() ? blackPlayer : whitePlayer;
        Player player2 = blackPlayer.getId() > whitePlayer.getId() ? blackPlayer : whitePlayer;
        return Objects.hash(player1, player2);
    }
}
