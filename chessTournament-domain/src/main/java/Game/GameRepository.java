package Game;



import java.util.List;

public interface GameRepository {

    void add(Game game);

    void remove(Game game);

    void update(Game game);

    List<Game> list();

    boolean contains(Game game);

}
