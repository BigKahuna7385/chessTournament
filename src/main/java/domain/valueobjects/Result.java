package domain.valueobjects;

import domain.exceptions.InvalidResultException;

public final class Result {
    private final boolean WHITEWON;
    private final boolean BLACKWON;
    private final boolean DRAW;

    public Result(boolean WHITEWON, boolean BLACKWON, boolean DRAW) throws InvalidResultException {
        this.WHITEWON = WHITEWON;
        this.BLACKWON = BLACKWON;
        this.DRAW = DRAW;
        int cnt = 0;
        boolean[] booleans = {WHITEWON,BLACKWON,DRAW};
        for (Boolean b : booleans)
           if (b) cnt++;

        if (cnt != 1)
            throw new InvalidResultException();
    }

    public boolean whiteHasWon() {
        return WHITEWON;
    }

    public boolean blackHasWon() {
        return BLACKWON;
    }

    public boolean isDraw() {
        return DRAW;
    }

    @Override
    public int hashCode() {
        return Integer.getInteger("" + (whiteHasWon() ? 1 : 0) + (blackHasWon() ? 1 : 0) + (isDraw() ? 1 : 0));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Result result = (Result) obj;
        return isDraw() == result.isDraw() && blackHasWon() == result.blackHasWon() && whiteHasWon() == result.whiteHasWon();
    }
}
