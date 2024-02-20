import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BoardTest {
    @Test
    void testSize() {
        Board game = new Board(5);
        Assertions.assertEquals(5, game.getSize(),"Board size is not 5");
    }
    @Test
    void mineDistributionTest() {
        Board game = new Board(20);
        game.distributeMines(75);
        Assertions.assertEquals(75, game.getMinecount(), "Mines are not 10");
    }
}
