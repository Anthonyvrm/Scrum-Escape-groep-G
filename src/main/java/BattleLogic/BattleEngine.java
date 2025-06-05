package BattleLogic;

import Commands.NextRoomCommand;
import Commands.*;
import Commands.StatusCommand;
import Game.GameInputHandler;
import Game.*;
import classes.*;
import classes.RoomNavigator;

import java.util.Scanner;

public class BattleEngine {
    private Player player;
    private BattleInputHandler inputHandler;
    private Monster monster;
    private Game game;

    // Constructor initializes player, inputHandler and monster.
    public BattleEngine(Player player, Monster monster) {
        this.player = player;
        this.inputHandler = new BattleInputHandler(new java.util.Scanner(System.in));
        this.monster = monster;
        setupCommands();
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    // Register commands for battle.
    private void setupCommands() {
        inputHandler.registerCommand("Attack", new SlashCommand(player, monster));
        inputHandler.registerCommand("Block", new BlockCommand(player, monster));
        inputHandler.availableCommands.add("- Attack");
        inputHandler.availableCommands.add("- Block");
    }

    // Handles battle loop.
    public void runBattle(Room room, Player player) {
        while (true) {
            //Handles user input during battle.
            inputHandler.handleBattleInput();

            // Check if the monster has been defeated.
            if (monster.getHealthPoints() <= 0) {
                System.out.println("You defeated the " + monster.getClass().getSimpleName() + "!");
                Scanner scanner = new Scanner(System.in);

                // Marks the room as completed.
                room.setIsCorrect(true);
                room.notifyObservers(true);

                // Asks the player if he wants to continue.
                System.out.print("Do you want to continue to the next room? (yes/no): ");
                String answer = scanner.nextLine().trim().toLowerCase();

                // Increases the progress of the player.
                player.setVoortgang(player.getVoortgang() + 1);


                // Move to the next room if the player commands so.
                if (answer.equals("yes") || answer.equals("y")) {
                    RoomNavigator navigator = new RoomNavigator(Game.getRooms(), player, new GameUI());
                    navigator.goToNextRoom();
                } else {
                    System.out.println("You chose to stay. You can continue exploring or type 'go to next' later.");
                }

                break;
                // Check if the player has been defeated.
            } else if (player.getStatus() <= 0) {
                System.out.println("You have been defeated by the " + monster.getClass().getSimpleName() + "!");
                System.out.println("Game Over.");
                break;
            }
        }
    }

    // Starts the battle loop in the current room with the player.
    public void startBattle(Room room, Player player) {
        player.printStatus();
        System.out.println(monster.getHealthPoints());
        System.out.println("You are now in battle!");
        runBattle(room, player);
    }
}
