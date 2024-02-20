import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class StartListener implements ActionListener {
    GUI grid;
    public StartListener(GUI game) {
        this.grid = game;

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String selected = "Medium";
        ButtonGroup difficulty = grid.getDifficultySetting();
        Board game;
        for (Enumeration<AbstractButton> buttons = difficulty.getElements(); buttons.hasMoreElements(); ) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                selected = button.getText();

            }
        }
        switch (selected) {
            case "Easy":
                game = new Board(9);
                game.distributeMines(10);
                break;
            case "Hard":
                game = new Board(20);
                game.distributeMines(75);
                break;
            default:
                game = new Board(16);
                game.distributeMines(40);
                break;
        }
        grid.displayBoard(game);
    }
}
