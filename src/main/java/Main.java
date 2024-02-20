// import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        GUI display = new GUI();
        display.displaySetup();
    }
}
        /*
        This code was only used for old console implementation:

        public void oldMain() {
            Board game = new Board(7);
            GUI display = new GUI();
            game.distributeMines(4);
            Tile[][] Tiles = game.getTiles();
            display.displayBoard(game, 1);
            while (!game.getEnd()) {
                int xpos = (userInput("Enter the row of the desired cell: ")-1);
                int ypos = (userInput("Enter the column of the desired cell: ")-1);
                try {
                    Tile target = Tiles[xpos][ypos];
                    if (userInput("Enter '1' if you would like to flag a tile: ") == 1) {
                        game.flagTile(target);
                    } else {
                        if (!target.getFlagged()) {
                            game.revealTile(target);
                        } else {
                            System.out.println("That tile is currently flagged");
                        }
                    }
                    display.displayBoard(game, 1);
                } catch (Exception e) {
                    System.out.println("That tile does not exist");
                }

            }
        }

    public static int userInput(String Prompt) { //Records user input, uses a supplied prompt
        Scanner reader = new Scanner(System.in);
        System.out.print(Prompt);
        boolean loop;
        int output = 0;
        do {
            String input = reader.next();
            try {
                output = Math.abs(Integer.parseInt(input));
                loop = false;
            } catch (Exception e) {
                System.out.println("Input must be a number");
                loop = true;
            }
        } while (loop);
        return output;
    }
         */