package Commands;

import Interface.Command;
import classes.Player;

// Command to display the player's current status
public class StatusCommand implements Command {
    private final Player player;

    // Constructor StatusCommand
    public StatusCommand(Player player) {
        this.player = player;
    }

    // Executes printing status of the player.
    @Override
    public void execute() {
        player.printStatus();
    }
}

