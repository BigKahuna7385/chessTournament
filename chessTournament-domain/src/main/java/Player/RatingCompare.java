package Player;

import java.util.Comparator;

public class RatingCompare implements Comparator<Player> {

    @Override
    public int compare(Player o1, Player o2) {
        if (o1.getRating().getElo() != null && o2.getRating().getElo() != null)
            return o2.getRating().getElo().getRatingNumber() - o1.getRating().getElo().getRatingNumber();
        return o2.getRating().getDwz().getRatingNumber() - o1.getRating().getDwz().getRatingNumber();
    }

}
