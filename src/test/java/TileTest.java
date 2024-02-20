import org.junit.jupiter.api.Test;

class TileTest {
    @Test
    void TileTests() {
        Board game = new Board(1);
        Tile tile = game.getTiles()[0][0];
        Board game2 = new Board(1);

        int[][] array = {{1},{2,4,5},{3}};
        tile.setNeighbours(array);
        tile.setXpos(tile.getXpos());
        tile.setYpos(tile.getYpos());
        tile.setOwner(game2);

    }
    @Test
    void ClickTests() {
        Tile tile = new Board(1).getTiles()[0][0];
        tile.getButton().doClick();
    }
}
