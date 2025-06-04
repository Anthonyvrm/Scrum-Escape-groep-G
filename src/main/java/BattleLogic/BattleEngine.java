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
    public BattleEngine(Player player, Monster monster) {
        this.player = player;

        this.inputHandler = new BattleInputHandler(new java.util.Scanner(System.in));
        this.monster = monster;
        setupCommands();
    }

    public void setPlayer(Player player) {
        this.player = player;
    }



    private void setupCommands() {
        inputHandler.registerCommand("Attack", new SlashCommand(player, monster));
        inputHandler.registerCommand("Block", new BlockCommand(player, monster));
        inputHandler.availableCommands.add("- Attack");
        inputHandler.availableCommands.add("- Block");
    }
    public void runBattle(Room room, Player player) {
        while (true) {
            inputHandler.handleBattleInput();
            if (monster.getHealthPoints() <= 0) {
                System.out.println("You defeated the " + monster.getClass().getSimpleName() + "!");

                Scanner scanner = new Scanner(System.in);
                room.setIsCorrect(true);
                room.notifyObservers(true);
                System.out.print("Do you want to continue to the next room? (yes/no): ");
                String answer = scanner.nextLine().trim().toLowerCase();

                player.setVoortgang(player.getVoortgang() + 1);


                if (answer.equals("yes") || answer.equals("y")) {
                    RoomNavigator navigator = new RoomNavigator(Game.getRooms(), player, new GameUI());

                    navigator.goToNextRoom();

                } else {
                    System.out.println("You chose to stay. You can continue exploring or type 'go to next' later.");
                }

                break;
            } else if (player.getStatus() <= 0) {
                System.out.println("You have been defeated by the " + monster.getClass().getSimpleName() + "!");
                System.out.println("Game Over.");
                break;
            }
        }
    }

    public void startBattle(Room room, Player player) {
        player.printStatus();
        System.out.println(monster.getHealthPoints());
        System.out.println("You are now in battle!");
        runBattle(room, player);




    }
}
