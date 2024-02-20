import com.sun.source.tree.AssertTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BoardTest {
    @Test
    void buildTests() {
        Board game = new Board(20);
        Assertions.assertEquals(20, game.getSize(),"Board size is not 20");
        game.distributeMines(75);
        Assertions.assertEquals(75, game.getMinecount(), "Mines are not 75");
    }
    @Test
    void mineTests() {
        Board game = new Board(20);

        Tile[][] grid = game.getTiles();
        grid[5][5].setMine(true); //set up some mine positions for testing
        grid[1][1].setMine(true);
        grid[0][0].setMine(false);
        game.revealTile(grid[5][5]); //First click a mine
        game.revealTile(grid[0][0]); //reveal an edge tile with a neighboring mine
        game.revealTile(grid[2][10]); //reveal a tile with no neighboring mines
        game.flagTile(grid[1][1]); //flag a mine
        game.revealTile(grid[1][1]); //attempt to reveal a flagged tile
        game.setRevealed(game.getRevealed());
        game.flagTile(grid[1][1]); //unflag the mine
        game.revealTile(grid[1][1]); //reveal the unflagged mine
        game.setFirstClick(true); //check first click can be set
        game.setEnd(true); //check end can be set
        Assertions.assertTrue(game.getEnd(), "End found not to be true"); //check if getEnd works

    }
}
