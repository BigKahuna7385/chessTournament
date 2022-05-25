package transport;

import player.Player;
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
