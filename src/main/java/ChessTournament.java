import domain.aggregates.Player;
import domain.exceptions.*;
import domain.repositories.PlayerRepositoryImpl;
import usecases.CreatePlayer;
import usecases.exceptions.PlayerAlreadyRegistered;

public class ChessTournament {

    public static void main(String[] args) {
        PlayerRepositoryImpl playerRepository = new PlayerRepositoryImpl();
        CreatePlayer createPlayer = new CreatePlayer(playerRepository);
        try {
            createPlayer.create(Player.builder()
                    .playerInfo("Daniel",null,"SC Oberhausen-Rheinhausen",12)
                    .rating(null,1448)
                    .build());
        } catch (PlayerAlreadyRegistered | InvalidListNumberException | InvalidPlayerInfoException |
                 InvalidPlayerNameExeption | InvalidRatingException | InvalidRatingNumberException e) {
            throw new RuntimeException(e);
        }
    }

}
