package Commands;

import Game.GameUI;
import Interface.Command;
import classes.Player;

import java.util.Scanner;

public class JokerCommand implements Command {
    private final Player player;
    private final GameUI gameUI;

    public JokerCommand(Player player, GameUI gameUI) {
        this.player = player;
        this.gameUI = gameUI;
    }

    @Override
    public void execute() {
        System.out.println("Do you want to use your joker?");
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().trim().equalsIgnoreCase("yes")) {
            if (player.getJoker() != null) {
                player.getJoker().useJokerIn(player.getPosition());
            } else {
                gameUI.showMessage("You have no joker available!");
            }
        }
        else {
            gameUI.showMessage("Okay, no problem!");
        }
    }
}

