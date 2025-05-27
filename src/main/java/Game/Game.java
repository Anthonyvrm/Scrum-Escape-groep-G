package Game;

import classes.Player;
import classes.Room;

import java.util.List;

public class Game {
    private final Player player;
    private final GameEngine gameEngine;


    public Game(Room room, Player player) {
        this.player = player;
        this.gameEngine = new GameEngine(player, List.of(room));
    }

    public Game(Player player) {
        this.player = player;
        this.gameEngine = new GameEngine(player, List.of());
    }

    public Game() {
        this.player = null;
        this.gameEngine = null;
    }

    public void setRooms(List<Room> rooms) {
        if (gameEngine != null) {
            gameEngine.setRooms(rooms);
        }
    }

    public void startGame(Room startingRoom) {
        if (gameEngine != null) {
            gameEngine.startGame();
        }
    }

    public static void endGame() {
        GameUI.endGame();
    }
}
