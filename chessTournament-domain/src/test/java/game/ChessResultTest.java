package game;

import exceptions.InvalidResultException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

public class ChessResultTest {

    @Test
    void invalidResultTest() {
        try {
            new ChessResult(true, true, true);
            fail("Expected a InvalidResultException to be thrown");
        } catch (InvalidResultException exception) {
            assertThat(exception.getMessage().equals("Invalid result"));
        }

        try {
            new ChessResult(true, true, false);
            fail("Expected a InvalidResultException to be thrown");
        } catch (InvalidResultException exception) {
            assertThat(exception.getMessage().equals("Invalid result"));
        }

        try {
            new ChessResult(true, false, true);
            fail("Expected a InvalidResultException to be thrown");
        } catch (InvalidResultException exception) {
            assertThat(exception.getMessage().equals("Invalid result"));
        }

        try {
            new ChessResult(false, true, true);
            fail("Expected a InvalidResultException to be thrown");
        } catch (InvalidResultException exception) {
            assertThat(exception.getMessage().equals("Invalid result"));
        }

        try {
            new ChessResult(false, false, false);
            fail("Expected a InvalidResultException to be thrown");
        } catch (InvalidResultException exception) {
            assertThat(exception.getMessage().equals("Invalid result"));
        }
    }

}
