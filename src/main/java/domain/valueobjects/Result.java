package domain.valueobjects;

import domain.exceptions.InvalidResultException;

import java.util.Objects;

public final class Result {
    private final boolean whiteWon;
    private final boolean blackWon;
    private final boolean draw;


    public Result(boolean whiteWon, boolean blackWon, boolean draw) throws InvalidResultException {
        this.whiteWon = whiteWon;
        this.blackWon = blackWon;
        this.draw = draw;

        if (!checkThatOnlyOneIsTrue())
            throw new InvalidResultException();

    }

    public boolean checkThatOnlyOneIsTrue(){
        return ((whiteWon ? 1 : 0) + (blackWon ? 1 : 0) + (draw ? 1 : 0)) == 1;
    }

    public boolean whiteHasWon() {
        return whiteWon;
    }

    public boolean blackHasWon() {
        return blackWon;
    }

    public boolean isDraw() {
        return draw;
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

