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
        Game.allRooms = rooms;
    }
    public static List<Room> getRooms() {
        return allRooms;
    }


    public void useJoker() {
        if (playerJoker != null) {
            playerJoker.useJokerIn(player.getPosition());
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
