import domain.aggregates.Player;
import domain.exceptions.*;
import domain.repositories.PlayerRepositoryImpl;
import usecases.AddPlayer;
import usecases.exceptions.PlayerAlreadyRegistered;

public class ChessTournament {

    public static void main(String[] args) {
        PlayerRepositoryImpl playerRepository = new PlayerRepositoryImpl();
        AddPlayer createPlayer = new AddPlayer(playerRepository);
        try {
            createPlayer.addPlayer(Player.builder()
                    .playerInfo("Daniel","Burger","SC Oberhausen-Rheinhausen",12)
                    .rating(null,1448)
                    .build());
        } catch (PlayerAlreadyRegistered | InvalidListNumberException | InvalidPlayerInfoException |
                 InvalidPlayerNameExeption | InvalidRatingException | InvalidRatingNumberException e) {
            throw new RuntimeException(e);
        }
    }

}
