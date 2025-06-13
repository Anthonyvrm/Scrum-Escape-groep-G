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
import static org.junit.jupiter.api.Assertions.*;

public class RoomNavigatorNextRoomTest {

    private RoomNavigator navigator;

    @BeforeEach
    void setUp() {

        List<Room> rooms = new ArrayList<>();

        Player player = new Player();
        GameUI gameUI = new GameUI();


        Room room1 = new TestRoom("Room1", null, true, null);
        Room room2 = new TestRoom("Room2", null, true, null);
        Room room3 = new TestRoom("Room3", null, true, null);
        Room room4 = new TestRoom("Room4", null, true, null);
        Room room5 = new TestRoom("Room5", null, true, null);
        Room room6 = new TestRoom("Room6", null, true, null);

        rooms.addAll(Arrays.asList(room1, room2, room3, room4, room5, room6));
        navigator = new RoomNavigator(rooms, player, gameUI);

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
}

