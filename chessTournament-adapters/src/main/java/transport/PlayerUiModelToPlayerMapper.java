package transport;

import Player.Player;
import application.player.PlayerService;
import exceptions.*;

public class PlayerUiModelToPlayerMapper {
    public Player map(PlayerUiModel playerUiModel) throws InvalidListNumberException, InvalidPlayerInfoException, InvalidPlayerNameExeption, InvalidRatingNumberException, InvalidRatingException {
        return Player.builder()
                .playerInfo(playerUiModel.getFirstName(), playerUiModel.getLastName(), playerUiModel.getClubName(), playerUiModel.getListNumber())
                .rating(playerUiModel.getElo(),playerUiModel.getDwz())
                .id(playerUiModel.getId())
                .build();
    }
}
