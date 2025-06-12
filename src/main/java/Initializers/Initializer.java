package Initializers;

import Game.Game;
import PlayerCreation.PlayerCreation;
import classes.Player;
import classes.Room;

import java.util.List;

public class Initializer {
    //activates player creation, room creation, roomobservers and calls the startGame() method
    public static void initializeGame() {
        Player player = createPlayer();
        List<Room> allRooms = InitializeRooms.createRoomsInOrder(player);
        InitializeRooms.registerObservers(allRooms, player);
        startGame(player, allRooms);
    }

    private static Player createPlayer() {
        return PlayerCreation.createCharacter();
    }

    //Starts the game
    private static void startGame(Player player, List<Room> rooms) {
        Game game = new Game(player);
        game.setRooms(rooms);
        game.startGame(rooms.getFirst());
    }
}
