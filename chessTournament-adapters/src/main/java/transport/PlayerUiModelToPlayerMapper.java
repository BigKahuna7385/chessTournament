package transport;

import Player.Player;
import application.player.PlayerService;
import exceptions.*;

public class PlayerUiModelToPlayerMapper {
    public Player apply(PlayerUiModel playerUiModel) throws InvalidListNumberException, InvalidRatingNumberException, InvalidPlayerInfoException, InvalidPlayerNameExeption, InvalidRatingException {
        return map(playerUiModel);
    }

    public Player map(PlayerUiModel playerUiModel) throws InvalidListNumberException, InvalidPlayerInfoException, InvalidPlayerNameExeption, InvalidRatingNumberException, InvalidRatingException {
        return Player.builder()
                .playerInfo(playerUiModel.getFirstName(), playerUiModel.getLastName(), playerUiModel.getClubName(), playerUiModel.getListNumber())
                .rating(playerUiModel.getElo(),playerUiModel.getDwz())
                .build();
    }
}
