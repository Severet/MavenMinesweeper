import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.event.MouseEvent;

class TileTest {
    @Test
    void TileTests() {
        Board game = new Board(1);
        Tile tile = game.getTiles()[0][0];
        Board game2 = new Board(1);

        int[][] array = {{1},{2,4,5},{3}};
        tile.setNeighbours(array);
        tile.setXpos(5);
        Assertions.assertEquals(5, tile.getXpos(), "getXpos did not return 5");
        tile.setYpos(7);
        Assertions.assertEquals(7, tile.getYpos(), "getYpos did not return 7");
        tile.setOwner(game2);

    }
}
