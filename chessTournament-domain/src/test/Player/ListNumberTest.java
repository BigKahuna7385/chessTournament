package Player;

import exceptions.InvalidListNumberException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

public class ListNumberTest {

    @Test
    void createInvalidListNumber(){
        try{
            new ListNumber(-1);
            fail("Expected a InvalidListNumberException to be thrown");
        } catch (InvalidListNumberException exception) {
            assertThat(exception.getMessage().equals("Invalid list number"));
        }
    }
}
