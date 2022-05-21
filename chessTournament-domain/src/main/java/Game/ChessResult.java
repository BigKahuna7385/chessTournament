package Game;

import exceptions.InvalidResultException;

import java.util.Objects;

public final class ChessResult {
    final boolean whiteWon;
    final boolean blackWon;
    final boolean draw;

    public ChessResult(boolean whiteWon, boolean blackWon, boolean draw) throws InvalidResultException {
        this.whiteWon = whiteWon;
        this.blackWon = blackWon;
        this.draw = draw;

        if (!checkThatOnlyOneIsTrue())
            throw new InvalidResultException();

    }

    public boolean hasWhiteWon() {
        return whiteWon;
    }

    public boolean hasBlackWon() {
        return blackWon;
    }

    public boolean isDrawn() {
        return draw;
    }

    public boolean checkThatOnlyOneIsTrue() {
        return ((whiteWon ? 1 : 0) + (blackWon ? 1 : 0) + (draw ? 1 : 0)) == 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessResult chessResult = (ChessResult) o;
        return whiteWon == chessResult.whiteWon && blackWon == chessResult.blackWon && draw == chessResult.draw;
    }

    @Override
    public int hashCode() {
        return Objects.hash(whiteWon, blackWon, draw);
    }

}

