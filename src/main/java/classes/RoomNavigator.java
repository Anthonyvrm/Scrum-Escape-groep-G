package classes;

import Game.GameUI;

import java.util.List;

public class RoomNavigator {
    // List of rooms.
    private List<Room> rooms;
    private int currentRoomIndex = 0;
    private boolean roomChanged = false;
    private final Player player;
    private final GameUI gameUI;

    // Constructor initializes the RoomNavigator with rooms, player, and gameUI.
    public RoomNavigator(List<Room> rooms, Player player, GameUI gameUI) {
        this.rooms = rooms;
        this.player = player;
        this.gameUI = gameUI;
    }

    // Sets rooms list and set currentRoomIndex to 0.
    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
        this.currentRoomIndex = 0;
    }

    // Set current room index.
    public void setCurrentRoomIndex(int currentRoomIndex) {

        if (currentRoomIndex >= 0 && currentRoomIndex < rooms.size()) {
            this.currentRoomIndex = currentRoomIndex;
        } else {
            throw new IndexOutOfBoundsException("Invalid room index: " + currentRoomIndex);
        }
    }

    // Get the current room position of the player.
    public Room getCurrentRoom() {
        return rooms.get(currentRoomIndex);
    }

    // If current room is completed advance the player to the next room.
    public void goToNextRoom() {

        Room currentRoom = rooms.get(currentRoomIndex);
        roomChanged = false;

        // If the room is not completed, don't let the player advance.
        if (!currentRoom.isCorrect) {

            gameUI.showMessage("You gotta finish the room " + player.getName() + " !");

            return;
        }

        currentRoomIndex++;
        roomChanged = true;

        // Advance the player to the next room or end the game.
        if (currentRoomIndex < rooms.size()) {

            Room nextRoom = rooms.get(currentRoomIndex);
            player.setPosition(nextRoom);

            gameUI.showMessage("You are going to the next room called: " + nextRoom.getName());
            gameUI.showMessage("");

            nextRoom.runEscapeRoom();

        } else {
            gameUI.showMessage("You finished the game YIPPIEEE!");
            GameUI.endGame();
        }
    }


    // Returns whether the room ws changed.
    public boolean wasRoomChanged() {
        return roomChanged;
    }
}


