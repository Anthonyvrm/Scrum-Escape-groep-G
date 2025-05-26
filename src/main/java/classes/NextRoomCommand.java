package classes;

public class NextRoomCommand implements Command {
    private final RoomNavigator roomNavigator;
    private final Player player;

    public NextRoomCommand(RoomNavigator roomNavigator, Player player) {
        this.roomNavigator = roomNavigator;
        this.player = player;
    }

    @Override
    public void execute() {
        roomNavigator.goToNextRoom();
        if (roomNavigator.wasRoomChanged()) {
            player.setVoortgang(player.getVoortgang() + 1);
        }
    }
}

