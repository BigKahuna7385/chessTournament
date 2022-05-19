package application.game;

import Game.Game;
import Game.GameRepository;
import Player.Player;
import Player.PlayerRepository;
import Round.Round;
import Round.RoundRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GameServiceTest {


    @Test
    void getGameOfPlayerInRound() {
        GameService gameService = new GameService(mock(GameRepository.class),mock(PlayerRepository.class),mock(RoundRepository.class));

        Player player = mock(Player.class);

        Game game = mock(Game.class);
        when(game.getWhitePlayer()).thenReturn(player);
        Game[] games = {game};
        Round round = mock(Round.class);
        when(round.getGames()).thenReturn(games);
        assertThat(gameService.getGameOfPlayerInRound(round,player)).isEqualTo(game);
    }

    @Test
    void getResultOf() {
    }

    @Test
    void createNew() {
    }

    @Test
    void getAllGamesOf() {
    }

    @Test
    void getAllGamesIn() {
    }

    @Test
    void getAllGames() {
    }
}