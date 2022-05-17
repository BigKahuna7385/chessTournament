package usecases;

import domain.aggregates.Player;
import domain.exceptions.*;
import domain.repositories.PlayerRepository;
import domain.repositories.PlayerRepositoryImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import usecases.exceptions.PlayerAlreadyRegistered;

public class CreatePlayerTest {
    
    static CreatePlayer createPlayer;

    @BeforeAll
    public static void init(){
        createPlayer = new CreatePlayer(new PlayerRepositoryImpl());
    }
    
    @Test
    public void createPlayerTest() throws InvalidListNumberException, InvalidPlayerInfoException, InvalidPlayerNameExeption, InvalidRatingNumberException, InvalidRatingException, PlayerAlreadyRegistered {
        Player player = Player.builder()
                .playerInfo("Daniel","Burger", "SC Oberhausen-Rheinhausen", 12)
                .rating(null,1448)
                .build();

        createPlayer.create(player);

    }
    
}
