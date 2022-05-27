package application.crosstable;

import application.game.GameService;
import application.player.PlayerService;
import game.Game;
import player.Player;

import java.util.ArrayList;
import java.util.List;

public class CrossTableService {

    private PlayerService playerService;

    public CrossTableService( PlayerService playerService) {
        this.playerService = playerService;
    }

    public Object[] createCrossTableFor(Player player, Object[] rowInfo, int infoBeforeScore) {
        List<String> crossTableRow = new ArrayList<>();
        for (Player rankedPlayer : playerService.getRankedPlayers()) {
            if (rankedPlayer == player)
                crossTableRow.add("x");
            else {
                crossTableRow.add(playerService.getScoreOf(player).vs(rankedPlayer));
            }
        }
        Object[] rowObject = new Object[crossTableRow.size() + rowInfo.length];

        for (int i = 0; i < rowObject.length; i++) {
            if (i < infoBeforeScore)
                rowObject[i] = rowInfo[i];
            else if (i < infoBeforeScore + crossTableRow.size())
                rowObject[i] = crossTableRow.get(i - infoBeforeScore);
            else
                rowObject[i] = rowInfo[i - crossTableRow.size()];
        }
        return rowObject;
    }

}
