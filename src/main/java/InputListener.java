import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InputListener implements MouseListener {
    Board game;
    Tile target;
    public InputListener(Tile target) {
        game = target.getOwner();
        this.target = target;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JButton b = target.getButton();
        if (e.getButton() == 1) { //Left-click behaviour
            if (!target.getFlagged()) { //Tile must not be flagged for a left click to work
                game.revealTile(target);
                if (target.getMine()) {
                    b.setText("X");
                    game.setRevealed(-1); //This triggers the program to end with a loss
                } else if (game.checkNeighbors(target) == 0) { //This calculates the number to be displayed on a revealed tile
                    b.setText(String.valueOf(game.checkNeighbors(target)));
                }
            }
        } else if (e.getButton()==3) { //Right-click behaviour
            if (!target.getRevealed()) { //Tile must not be revealed for a right click to work
                game.flagTile(target);
                if (target.getFlagged()) {
                    b.setText("⚑");
                } else if (!target.getFlagged()) {
                    b.setText("");
                }
            }
        }
        if (game.getRevealed() == -1) { //Detects if a mine has been revealed
            JOptionPane.showMessageDialog(null, "YOU LOSE :(");
            System.exit(0);
        } else if (game.getRevealed() == (game.getSize() * game.getSize())-game.getMinecount()) { //Detects if any safe tiles remain
            JOptionPane.showMessageDialog(null, "YOU WIN B)");
            System.exit(0);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}