package transport;

import Player.Player;

public class PlayerToPlayerUIMapper {

    public PlayerUiModel map(Player player) {
        return new PlayerUiModel(player.getPlayerInfo().getName().getFirstName(),
                player.getPlayerInfo().getName().getLastName(),
                player.getPlayerInfo().getClubName(),
                player.getPlayerInfo().getListNumber().getListNumber(),
                player.getRating().getElo().getRatingNumber(),
                player.getRating().getDwz().getRatingNumber(),
                player.getId(),
                player.getScore(),
                player.getTournamentRating() == null ? 0 : player.getTournamentRating().getBuchholzScore(),
                player.getTournamentRating() == null ? 0 : player.getTournamentRating().getSonnebornBergerScore()
        );
    }
}
