import javax.swing.*;
import java.awt.*;

public class GUI {
    private JFrame window = new JFrame("Minesweeper");
    private JPanel difficultyPanel;
    private ButtonGroup difficultySetting;
    public GUI() {
        this.window.setLayout(null);//using no layout managers
        this.window.setVisible(true);//making the frame visible
    }

    public void displayBoard(Board game) {
        window.getContentPane().removeAll();
        int l = game.getSize();
        window.setSize((l*45)+20,(l*45+40));
        window.revalidate();
        Tile[][] tiles = game.getTiles();
        int size = game.getSize();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                window.add(tiles[i][j].getButton());
                //Each Tile within the supplied Board has its button added to the GUI
            }
        }
        window.repaint();
    }
    public void displaySetup() {

        JLabel message = new JLabel("Please select a Difficulty Level:");
        message.setBounds(10,0,200,30);

        this.difficultyPanel = getjPanel(this);

        JButton start = new JButton("Start");
        start.setBounds(120,85,80,30);
        start.addActionListener(new StartListener(this));

        window.add(message);
        window.add(this.difficultyPanel);
        window.add(start);
        window.setSize(225, 160);
        window.repaint();
    }

    private static JPanel getjPanel(GUI game) {
        JRadioButton easy = new JRadioButton("Easy");
        JRadioButton medium = new JRadioButton("Medium");
        medium.setSelected(true);
        JRadioButton hard = new JRadioButton("Hard");

        ButtonGroup difficulty = new ButtonGroup();
        difficulty.add(easy);
        difficulty.add(medium);
        difficulty.add(hard);
        game.setDifficultySetting(difficulty);

        JPanel difficultyPanel = new JPanel(new GridLayout(0, 1));
        difficultyPanel.add(easy);
        difficultyPanel.add(medium);
        difficultyPanel.add(hard);
        difficultyPanel.setBounds(30,30,200,50);
        return difficultyPanel;
    }
    public JPanel getDifficultyPanel() {
        return this.difficultyPanel;
    }

    public ButtonGroup getDifficultySetting() {
        return difficultySetting;
    }
    public void setDifficultySetting(ButtonGroup b) {
        this.difficultySetting = b;
    }
}
   /*
    public void displayBoard(Board game, int c) { //This method is used for handling console display. The parameter is used only to enable this behaviour
        boolean boom = false;
        int remaining = 0;
        for (Tile[] i : game.getTiles()) {
            StringBuilder displayString = new StringBuilder();
            for (Tile j : i) {
                if (j.getFlagged()) {
                    displayString.append("[⚑]");
                    remaining++;
                }
                else if (!j.getRevealed()) {
                    displayString.append("[ ]");
                    remaining++;
                } else if (j.getMine()) {
                    displayString.append("[X]");
                    boom = true;
                } else if (j.getRevealed()) {
                    displayString.append("[").append(game.checkNeighbors(j)).append("]");
                } else {
                    displayString.append("[?]"); //This should never happen, but prevents the board losing shape in case of error
                }
            }
            System.out.println(displayString);
        }
        System.out.println("\n");
        if (boom) {
            System.out.println("▓▓▓ YOU LOSE! :( ▓▓▓");
            game.setEnd(true);
        } else if (remaining == game.getMinecount()) {
            System.out.println("▓▓▓ YOU WIN! B) ▓▓▓");
            game.setEnd(true);
        }
    }

     */
