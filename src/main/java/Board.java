import java.util.HashSet;

public class Board {
    private int revealed = 0; //This represents the number of discovered safe tiles.
    private int size;
    private boolean end = false;
    private Tile[][] Tiles;
    private int minecount;
    private boolean firstClick = true;
    public Board(int length) {
        this.size = length;
        this.Tiles = new Tile[size][size];
        for (int x=0 ; x<length ; x++) {
            for (int y=0 ; y < length ; y++) {
                Tiles[x][y] = new Tile(x, y, this);
            }
        }
    }

    public void distributeMines(int count) { //Randomly places mines
        HashSet<int[]> pos = new HashSet<>();
        do {
            int[] i = new int[2];
            i[0] = (int) (Math.random()*(this.size));
            i[1] = (int) (Math.random()*(this.size));
            // Generates a set of coordinates within the bounds of the grid
            try { //Tries to add the coordinates to the hash set
                pos.add(i);
            } catch (Exception ignored) {
                //If the coordinates are a duplicate then the program will not add or crash as the exception is handled
            }
        } while (pos.size()<count); // Continues generating coords and adding them if unique until the count quota has been met
        this.minecount = count;
        for (int[] m : pos) {
            this.Tiles[m[0]][m[1]].setMine(true); //sets the Mine boolean of the tiles at all generated coordinates to true
        }
    }


    public int checkNeighbors(Tile target) { //Used for calculating the number of mines adjacent to a Tile
        int mines = 0; //represents the number to be displayed on the tile
        int[][] neighbors = target.getNeighbours();
        for (int[] neighbor : neighbors) {
                try {
                    if (checkForMine(neighbor[0],neighbor[1])) {
                        mines++;
                        //If a mine is present at the coordinate then increment mines
                    }
                }
                catch(Exception ignored) {
                    /*
                    Edge tiles would ordinarily check outside the grid and cause an error.
                    This allows such cases to be skipped without issue
                     */
                }
            }
        return mines;
    }
    public boolean checkForMine(int x, int y) {
        return this.Tiles[x][y].getMine();
        //Checks the Tile of a given coordinate for a mine.
    }

    public void revealTile(Tile target) { //Reveals a tile. Should that tile have no neighboring mines then all of those tiles are revealed too
        target.setRevealed(true);
        revealed++;
        if (target.getMine() && this.firstClick) {
            target.setMine(false);
            this.firstClick = false;
        }
        target.getButton().setText(String.valueOf(checkNeighbors(target)));
        if (checkNeighbors(target)==0) { //
            for (int[] n : target.getNeighbours()) {
                try {
                    if (!this.Tiles[n[0]][n[1]].getRevealed()) {
                        revealTile(this.Tiles[n[0]][n[1]]);
                        //0-Value Tiles are recursively checked until none remain contiguously
                    }

                } catch (Exception ignored) {
                    /*
                    Edge tiles would ordinarily check outside the grid and cause an error.
                    This allows such cases to be skipped without issue
                     */
                }
            }
        }
    }
    public void flagTile(Tile target) { //swaps the flagged state of a given tile
        target.setFlagged(!target.getFlagged());
    }


    /*
    Getters and Setters
     */
    public int getSize() {
        return this.size;
    }
    public Tile[][] getTiles() {
        return this.Tiles;
    }
    public boolean getEnd() {
        return end;
    }
    public void setEnd(boolean end) {
        this.end = end;
    }
    public int getMinecount() {
        return this.minecount;
    }
    public int getRevealed() {
        return revealed;
    }
    public void setRevealed(int revealed) {
        this.revealed = revealed;
    }
    public boolean isFirstClick() {
        return firstClick;
    }
    public void setFirstClick(boolean firstClick) {
        this.firstClick = firstClick;
    }
}
