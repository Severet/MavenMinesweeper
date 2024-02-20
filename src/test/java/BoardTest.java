import com.sun.source.tree.AssertTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BoardTest {
    @Test
    void testSize() {
        Board game = new Board(5);
        Assertions.assertEquals(5, game.getSize(),"Board size is not 5");
    }
    @Test
    void mineTests() {
        Board game = new Board(20);
        game.distributeMines(75);
        Assertions.assertEquals(75, game.getMinecount(), "Mines are not 10");

        Tile[][] grid = game.getTiles();
        grid[2][2].setMine(true);
        grid[3][3].setMine(false);

        game.revealTile(grid[3][3]);

        game.flagTile(grid[2][2]);

        game.revealTile(grid[2][2]);

        game.flagTile(grid[2][2]);

        game.revealTile(grid[2][2]);

    }
}
