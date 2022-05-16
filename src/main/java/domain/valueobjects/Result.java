package domain.valueobjects;

public class Result {
    private final boolean WHITEWON;
    private final boolean BLACKWON;
    private final boolean DRAW;

    public Result(boolean WHITEWON, boolean BLACKWON, boolean DRAW) {
        this.WHITEWON = WHITEWON;
        this.BLACKWON = BLACKWON;
        this.DRAW = DRAW;
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
}
