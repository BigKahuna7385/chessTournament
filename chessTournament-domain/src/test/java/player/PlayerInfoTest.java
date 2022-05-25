package player;

import exceptions.InvalidListNumberException;
import exceptions.InvalidPlayerInfoException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class PlayerInfoTest {

    @Test
    void invalidPlayerInfo(){
        try{
            PlayerInfo.builder().clubName(null).playerName(null).listNumber(null).build();
            fail("Expected InvalidPlayerInfoException to be thrown");
        } catch (InvalidPlayerInfoException exception) {
            assert(exception.getMessage().equals("Invalid player info"));
        }

        try{
            PlayerInfo.builder().clubName("SC Rochade Dettenheim").playerName(null).listNumber(null).build();
            fail("Expected InvalidPlayerInfoException to be thrown");
        } catch (InvalidPlayerInfoException exception) {
            assert(exception.getMessage().equals("Invalid player info"));
        }

        try{
            PlayerInfo.builder().clubName("SC Rochade Dettenheim").playerName(null).listNumber(new ListNumber(12)).build();
            fail("Expected InvalidPlayerInfoException to be thrown");
        } catch (InvalidPlayerInfoException exception) {
            assert(exception.getMessage().equals("Invalid player info"));
        } catch (InvalidListNumberException e) {
            throw new RuntimeException(e);
        }
    }
}
