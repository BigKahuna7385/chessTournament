package Game;

import exceptions.InvalidResultException;

import java.util.Objects;

public final class Result {
    final boolean whiteWon;
    final boolean blackWon;
    final boolean draw;


    public Result(boolean whiteWon, boolean blackWon, boolean draw) throws InvalidResultException {
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

    public boolean isDraw() {
        return draw;
    }

    public boolean checkThatOnlyOneIsTrue() {
        return ((whiteWon ? 1 : 0) + (blackWon ? 1 : 0) + (draw ? 1 : 0)) == 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return whiteWon == result.whiteWon && blackWon == result.blackWon && draw == result.draw;
    }

    @Override
    public int hashCode() {
        return Objects.hash(whiteWon, blackWon, draw);
    }

}

