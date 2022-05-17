package domain.entities;

import java.util.UUID;

public class Tournament {

    private final Round[] rounds;

    private final String tournamentName;

    private final String uuid;

    public Tournament(Round[] rounds, String tournamentName) {
        this.rounds = rounds;
        this.tournamentName = tournamentName;
        this.uuid = UUID.randomUUID().toString();
    }

    public Round[] getRounds() {
        return rounds;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public String getUuid() {
        return uuid;
    }
}
