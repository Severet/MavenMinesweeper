import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoardTest {
    @Test
    void testSize() {
        Board game = new Board(5);
        Assertions.assertEquals(5, game.getSize(),"Board size is not 5");
    }
}
