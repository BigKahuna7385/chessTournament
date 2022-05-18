package Game;

import exceptions.InvalidResultException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

public class ResultTest {

    @Test
    void invalidResultTest() {
        try {
            new Result(true, true, true);
            fail("Expected a InvalidResultException to be thrown");
        } catch (InvalidResultException exception) {
            assertThat(exception.getMessage().equals("Invalid result"));
        }

        try {
            new Result(true, true, false);
            fail("Expected a InvalidResultException to be thrown");
        } catch (InvalidResultException exception) {
            assertThat(exception.getMessage().equals("Invalid result"));
        }

        try {
            new Result(true, false, true);
            fail("Expected a InvalidResultException to be thrown");
        } catch (InvalidResultException exception) {
            assertThat(exception.getMessage().equals("Invalid result"));
        }

        try {
            new Result(false, true, true);
            fail("Expected a InvalidResultException to be thrown");
        } catch (InvalidResultException exception) {
            assertThat(exception.getMessage().equals("Invalid result"));
        }

        try {
            new Result(false, false, false);
            fail("Expected a InvalidResultException to be thrown");
        } catch (InvalidResultException exception) {
            assertThat(exception.getMessage().equals("Invalid result"));
        }
    }

}
