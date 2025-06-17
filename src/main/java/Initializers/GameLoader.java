package Initializers;

import database.DeleteFinishedDAO;
import database.saveQuery;
import classes.Player;
import classes.Room;
import Game.Game;

import java.util.List;
import java.util.Scanner;

public class GameLoader {

    public static void loadOrNew() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Scrum Escape ===");
        System.out.println("1) Start New Game");
        System.out.println("2) Load Saved Game");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();

        if (choice == 2) {
            GameLoader.loadGame();
        } else {
            Initializer.initializeGame();
        }
    }
    public static void loadGame() {
        DeleteFinishedDAO.removeFinishedPlayer();
        List<Player> saves = saveQuery.getAllPlayers();

        if (saves.isEmpty()) {
            System.out.println("No saved games found. Starting a new game instead.");
            Initializer.initializeGame();
            return;
        }

        System.out.println("Select a save to load:");

        for (int i = 0; i < saves.size(); i++) {
            Player p = saves.get(i);
            System.out.printf(
                    "%d) %s — HP: %d, Progress: Room %d%n",
                    i + 1, p.getName(), p.getStatus(), p.getVoortgang()
            );
        }


        Scanner scanner = new Scanner(System.in);
        int pick;
        do {
            System.out.print("Enter number: ");
            pick = scanner.nextInt();
        } while (pick < 1 || pick > saves.size());

        Player player = saves.get(pick - 1);
        System.out.println(player.getVoortgang());

        List<Room> allRooms = InitializeRooms.createRoomsInOrder(player);
        InitializeRooms.registerObservers(allRooms, player);

        Game game = new Game(player);

        game.setRooms(allRooms);

        int index = player.getVoortgang();

        game.getGameEngine().getRoomNavigator().setCurrentRoomIndex(index);

        player.setPosition(allRooms.get(index));

        game.startGame(allRooms.get(index));
    }
}
