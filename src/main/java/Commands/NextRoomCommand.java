package Commands;

import Interface.Command;
import classes.Player;
import classes.RoomNavigator;

// Command that moves the player to the next room.
public class NextRoomCommand implements Command {
    private final RoomNavigator roomNavigator;
    private final Player player;

    // Constructor NextRoomCommand.
    public NextRoomCommand(RoomNavigator roomNavigator, Player player) {
        this.roomNavigator = roomNavigator;
        this.player = player;
    }

    @Override
    public void execute() {
        roomNavigator.goToNextRoom();

        // If the room changed add progress to player.
        if (roomNavigator.wasRoomChanged()) {
            player.setVoortgang(player.getVoortgang() + 1);
        }
    }
}

