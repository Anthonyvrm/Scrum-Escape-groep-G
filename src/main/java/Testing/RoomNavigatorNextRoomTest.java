package Testing;

import Game.GameUI;
import classes.Player;
import classes.Room;
import classes.RoomNavigator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RoomNavigatorRandwaardeTest extends RoomNavigator {

    // List of rooms.
    private List<Room> rooms;
    private int currentRoomIndex = 0;
    private boolean roomChanged = false;
    private Player player;
    private GameUI gameUI;

    // Constructor initializes the RoomNavigator with rooms, player, and gameUI.
    public RoomNavigatorRandwaardeTest (List<Room> rooms, Player player, GameUI gameUI) {
        super(rooms, player, gameUI);
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
        }
    }

    // Returns whether the room ws changed.
    public boolean wasRoomChanged() {
        return roomChanged;
    }
}


public class RoomNavigatorNextRoomTest {

    private RoomNavigatorRandwaardeTest navigator;

    @BeforeEach
    void setUp() {
        List<Room> rooms = new ArrayList<>();

        Player player = new Player();
        GameUI gameUI = new FakeGameUI();


        Room room1 = new TestRoom("Room1",null,true, null);
        Room room2 = new TestRoom("Room2",null,true, null);
        Room room3 = new TestRoom("Room3",null,true, null);
        Room room4 = new TestRoom("Room4",null,true, null);
        Room room5 = new TestRoom("Room5",null,true, null);
        Room room6 = new TestRoom("Room6",null,true, null);

        rooms.addAll(Arrays.asList(room1, room2, room3, room4, room5, room6));
        navigator = new RoomNavigatorRandwaardeTest(rooms, player, gameUI);

    }

    @Test
    public void testNextRoom() {
        navigator.setCurrentRoomIndex(0);
        navigator.goToNextRoom();
        assertEquals("Room2", navigator.getCurrentRoom().getName());
    }

    @Test
    public void testNextRoomMiddle() {
        navigator.setCurrentRoomIndex(2);
        navigator.goToNextRoom();
        assertEquals("Room4", navigator.getCurrentRoom().getName());
    }

    @Test
    public void testNextRoomLast() {
        navigator.setCurrentRoomIndex(4);
        navigator.goToNextRoom();
        assertEquals("Room6", navigator.getCurrentRoom().getName());
    }

    @Test
    public void testNextRoomEndGame() {
        navigator.setCurrentRoomIndex(5);
        navigator.goToNextRoom();
        assertEquals(null, navigator.getCurrentRoom().getName());

    }
}
