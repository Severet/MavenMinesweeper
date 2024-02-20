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
        grid[1][1].setMine(true);
        grid[0][0].setMine(false);

        game.revealTile(grid[0][0]);

        game.flagTile(grid[1][1]);

        game.revealTile(grid[2][2]);
        Assertions.assertTrue(grid[0][0].getRevealed());

        game.flagTile(grid[2][2]);

        game.revealTile(grid[2][2]);
        game.setFirstClick(true);
        game.setEnd(true);
        Assertions.assertTrue(game.getEnd(), "End found not to be true");

    }
}
