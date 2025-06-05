package Game;

import Joker.Joker;
import classes.Player;
import classes.Room;

import java.util.List;

public class Game {
    private Joker playerJoker;
    private final Player player;
    private final GameEngine gameEngine;
    private static List<Room> allRooms;


    // Constructor initializing the game with a specific starting room and player.
    public Game(Room room, Player player) {
        this.player = player;
        this.gameEngine = new GameEngine(player, List.of(room));
    }

    // Constructor initializing the game with a player.
    public Game(Player player) {
        this.player = player;
        this.gameEngine = new GameEngine(player, List.of());
    }

    public Game() {
        this.player = null;
        this.gameEngine = null;
    }

    // Sets the list of rooms in the game.
    public void setRooms(List<Room> rooms) {
        if (gameEngine != null) {
            gameEngine.setRooms(rooms);
        }
        Game.allRooms = rooms;
    }
    // Returns the list of all rooms in the game.
    public static List<Room> getRooms() {
        return allRooms;
    }

    // Starts the game.
    public void startGame(Room startingRoom) {
        if (gameEngine != null) {
            gameEngine.startGame();
        }
    }

    // Ends the game.
    public static void endGame() {
        GameUI.endGame();
    }
}
