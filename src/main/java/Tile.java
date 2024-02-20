import javax.swing.*;
public class Tile {
    private boolean mine = false;
    private int xpos;
    private int ypos;
    private boolean revealed = false;
    private boolean flagged = false;
    private int[][] neighbours = new int[8][2];
    private static final int[][] nMatrix = {{-1, -1},{-1, 0},{-1, 1},{0, -1},{0, 1},{1, -1},{1, 0},{1, 1}};
    // This attribute is used to calculate the neighbours of each Tile quickly
    private JButton button = new JButton();
    // Tiles store the required information for their own buttons.
    private Board owner;

    public Tile(int xpos, int ypos, Board game) {
        this.xpos = xpos;
        this.ypos = ypos;
        this.owner = game;
        for (int n=0; n < this.neighbours.length; n++) {
            neighbours[n][0] = (xpos + nMatrix[n][0]);
            neighbours[n][1] = (ypos + nMatrix[n][1]);
            // This calculates the neighbours for the Tile for quick recall when deciding what number to display on a safe tile
        }
        this.button.setBounds(xpos*45, ypos*45, 43, 43);
        this.button.addMouseListener(new InputListener(this));
    }

    /*
    Getters and Setters:
     */
    public boolean getMine() {
        return this.mine;
    }
    public void setMine(boolean state) {
        this.mine = state;
    }
    public int getXpos() {
        return this.xpos;
    }
    public void setXpos(int pos) {
        this.xpos = pos;
    }
    public int getYpos() {
        return this.ypos;
    }
    public void setYpos(int pos) {
        this.ypos = pos;
    }
    public boolean getRevealed() {
        return revealed;
    }
    public void setRevealed(boolean revealed) {
        this.revealed = revealed;
    }
    public boolean getFlagged() {
        return flagged;
    }
    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }
    public int[][] getNeighbours() {
        return neighbours;
    }
    public void setNeighbours(int[][] neighbours) {
        this.neighbours = neighbours;
    }
    public JButton getButton() {
        return button;
    }
    public Board getOwner() {
        return owner;
    }
    public void setOwner(Board owner) {
        this.owner = owner;
    }
}