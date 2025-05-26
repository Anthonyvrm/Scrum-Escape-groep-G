package classes;

import java.util.List;

public class RoomNavigator {
    private List<Room> rooms;
    private int currentRoomIndex = 0;
    private boolean roomChanged = false;
    private final Player player;
    private final GameUI gameUI;

    public RoomNavigator(List<Room> rooms, Player player, GameUI gameUI) {
        this.rooms = rooms;
        this.player = player;
        this.gameUI = gameUI;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
        this.currentRoomIndex = 0;
    }


    public Room getCurrentRoom() {
        return rooms.get(currentRoomIndex);
    }

    public void goToNextRoom() {
        Room currentRoom = rooms.get(currentRoomIndex);
        roomChanged = false;

        if (!currentRoom.isCorrect) {
            gameUI.showMessage("You gotta finish the room " + player.getName() + " !");
            return;
        }

        currentRoomIndex++;
        roomChanged = true;

        if (currentRoomIndex < rooms.size()) {
            Room nextRoom = rooms.get(currentRoomIndex);
            player.setPosition(nextRoom);
            gameUI.showMessage("You are going to the next room called: " + nextRoom.getName());
            nextRoom.runEscapeRoom();
        } else {
            gameUI.showMessage("You finished the game YIPPIEEE!");
            gameUI.endGame();
        }
    }

    public boolean wasRoomChanged() {
        return roomChanged;
    }
}

