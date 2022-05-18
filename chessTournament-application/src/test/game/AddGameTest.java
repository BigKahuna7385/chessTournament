package game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

public class AddGameTest {
/*
    static Player whitePlayer;
    static Player blackPlayer;
    static GameRepositoryImpl gameRepository;


    @BeforeAll
    public static void init() throws InvalidListNumberException, InvalidPlayerInfoException, InvalidPlayerNameExeption, InvalidRatingNumberException, InvalidRatingException {
        whitePlayer = Player.builder().playerInfo("Daniel", "Burger", "SF Oberhausen-Rheinhausen", 12).rating(null, 1448).build();
        blackPlayer = Player.builder().playerInfo("Denis", "Graf", "SF Neureut 1953 e.V.", 45).rating(null, 1248).build();
        gameRepository = new GameRepositoryImpl();
    }

    @Test
    public void addGame() throws GameAlreadyAddedException {
        Game game = new Game(whitePlayer, blackPlayer);
        AddGame addGame = new AddGame(gameRepository);
        addGame.addGame(game);
        assertThat(gameRepository.list()).contains(game);
    }

    @Test
    public void addGameTwice() throws GameAlreadyAddedException {
        Game game = new Game(whitePlayer, blackPlayer);
        AddGame addGame = new AddGame(gameRepository);
        addGame.addGame(game);
        assertThat(gameRepository.list()).contains(game);
        try {
            addGame.addGame(game);
            fail("Expected a GameAlreadyAddedException to be thrown");
        }catch(GameAlreadyAddedException exception){
            assertThat(exception.getMessage().equals("Game already in repository"));
        }

    }

 */

}
