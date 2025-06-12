package Testing;

import classes.RoomNavigator;
import classes.Room;
import classes.Player;
import Game.GameUI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RoomNavigatorTest {
    private RoomNavigator navigator;

    @BeforeEach
    void setUp() {
        List<Room> rooms = new ArrayList<>();

        Player player = new Player();
        GameUI gameUI = new GameUI();

        Room room1 = new TestRoom("Room1",null,true, null);
        Room room2 = new TestRoom("Room2",null,true, null);
        Room room3 = new TestRoom("Room3",null,true, null);
        Room room4 = new TestRoom("Room4",null,true, null);
        Room room5 = new TestRoom("Room5",null,true, null);
        Room room6 = new TestRoom("Room6",null,true, null);
        rooms.addAll(Arrays.asList(room1, room2, room3, room4, room5, room6));
        navigator = new RoomNavigator(rooms, player, gameUI);
    }


    // Ondergrens
    @Test
    public void testSetRoomIndexLower() {
        navigator.setCurrentRoomIndex(0);
        assertEquals("Room1", navigator.getCurrentRoom().getName());
    }

    // Midden
    @Test
    public void testSetRoomIndexMiddle() {
        navigator.setCurrentRoomIndex(2);
        assertEquals("Room3", navigator.getCurrentRoom().getName());
    }

    // Bovengrens
    @Test
    public void testSetRoomIndexUpper() {
        navigator.setCurrentRoomIndex(5);
        assertEquals("Room6", navigator.getCurrentRoom().getName());
    }

    // Rand onder
    @Test
    public void testSetRoomIndexException() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            navigator.setCurrentRoomIndex(-1);
        });
    }
}
