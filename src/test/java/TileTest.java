class TileTest {
    void TileTests() {
        Board game = new Board(1);
        Tile tile = game.getTiles()[0][0];

        int[][] array = {{1},{2,4,5},{3}};
        tile.setNeighbours(array);
        tile.setXpos(tile.getXpos());
        tile.setYpos(tile.getYpos());
    }
}
