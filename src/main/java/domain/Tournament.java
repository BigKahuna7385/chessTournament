package domain;

public class Tournament {

    private final Round[] rounds;

    public Tournament(Round[] rounds) {
        this.rounds = rounds;
    }

    public Round[] getRounds() {
        return rounds;
    }
}
