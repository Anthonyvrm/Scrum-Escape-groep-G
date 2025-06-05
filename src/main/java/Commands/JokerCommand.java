package Commands;

import Game.GameUI;
import Interface.Command;
import classes.Player;

import java.util.Scanner;

// The JokerCommand allows the player to use a Joker if they have one.
public class JokerCommand implements Command {
    private final Player player;
    private final GameUI gameUI;

    // Constructor JokerCommand.
    public JokerCommand(Player player, GameUI gameUI) {
        this.player = player;
        this.gameUI = gameUI;
    }

    // Executes the Joker command.
    @Override
    public void execute() {
        System.out.println("Do you want to use your joker?");
        Scanner scanner = new Scanner(System.in);

        // If the player wants a Joker and he has one.
        if (scanner.nextLine().trim().equalsIgnoreCase("yes")) {
            if (player.getJoker() != null) {
                player.getJoker().useJokerIn(player.getPosition());
            } else {
                // If the player doesn't have a Joker.
                gameUI.showMessage("You have no joker available!");
            }
        }
        else {
            // Player declines to use a Joker.
            gameUI.showMessage("Okay, no problem!");
        }
    }
}

