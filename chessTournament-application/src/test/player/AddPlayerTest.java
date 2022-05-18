package player;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;


public class AddPlayerTest {
    /*
    static AddPlayer addPlayer;
    static PlayerRepositoryImpl playerRepository;

    static Player player;

    @BeforeEach
    public void init() throws InvalidListNumberException, InvalidPlayerInfoException, InvalidPlayerNameExeption, InvalidRatingNumberException, InvalidRatingException {
        playerRepository = new PlayerRepositoryImpl();
        addPlayer = new AddPlayer(playerRepository);
        player = Player.builder()
                .playerInfo("Daniel","Burger", "SC Oberhausen-Rheinhausen", 12)
                .rating(null,1448)
                .build();
    }
    
    @Test
    public void addPlayerTest() throws PlayerAlreadyRegistered {
        addPlayer.addPlayer(player);
        assertThat(playerRepository.list()).contains(player);
    }

    @Test
    public void addPlayerTwiceTest() throws PlayerAlreadyRegistered {
        addPlayer.addPlayer(player);
        assertThat(playerRepository.list()).contains(player);
        try {
            addPlayer.addPlayer(player);
            fail("Expected a PlayerAlreadyRegistered to be thrown");
        }catch(PlayerAlreadyRegistered exception){
            assertThat(exception.getMessage().equals("Player is already registered"));
        }

    }

     */
    
}
