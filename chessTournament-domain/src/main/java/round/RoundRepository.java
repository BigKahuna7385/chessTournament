package round;



import java.util.List;

public interface RoundRepository {

    void add(Round round);

    void remove(Round round);

    void update(Round round);

    List<Round> list();

    Round getByRoundById(int currentRoundNumber);
}
