package usecases;

import domain.entities.Game;
import domain.exceptions.InvalidResultException;
import domain.valueobjects.Result;

public class SetGameResult {

    public void setGameResult(Game game, Result result){
        game.setResult(result);
    }

    public void setGameResult(Game game, boolean whiteWon, boolean blackWon, boolean draw) throws InvalidResultException {
        game.setResult(new Result(whiteWon,blackWon,draw));
    }

}
