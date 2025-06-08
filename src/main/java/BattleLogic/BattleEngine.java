package BattleLogic;

import Commands.*;
import Game.*;
import classes.*;
import java.util.Scanner;

public class BattleEngine {
    private Scanner scanner = new Scanner(System.in);
    private Player player;
    private final BattleInputHandler inputHandler;
    private final Monster monster;

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

    private void setupCommands() {
        inputHandler.registerCommand("1", new SlashCommand(player, monster));
        inputHandler.registerCommand("2", new BlockCommand(player, monster));
        inputHandler.availableCommands.add("- 1: Attack");
        inputHandler.availableCommands.add("- 2: Block");
    }

    // Main battle loop
    public void runBattle(Room room, Player player) {
        while (true) {

            inputHandler.handleBattleInput();
            
            if (isMonsterDefeated()) {
                handleVictory(room);
                break;
            } else if (isPlayerDefeated()) {
                handleDefeat();
                break;
            }
        }
    }

    private boolean isMonsterDefeated() {
        return monster.getHealthPoints() <= 0;
    }

    private boolean isPlayerDefeated() {
        return player.getStatus() <= 0;
    }

    private void handleVictory(Room room) {
        markRoomAsCompleted(room);
        handleNextRoomNavigation(room);
    }

    private void markRoomAsCompleted(Room room) {
        room.setIsCorrect(true);
        room.notifyObservers(true);
    }

    private void handleNextRoomNavigation(Room room) {
        String answer = askForNextRoom();
        if (shouldMoveToNextRoom(answer)) {
            navigateToNextRoom(room);
        } else {
            System.out.println("You chose to stay. You can continue exploring or type 'go to next' later.");
        }
    }

    private String askForNextRoom() {
        System.out.println();
        System.out.print("Do you want to continue to the next room? (yes/no): ");
        return scanner.nextLine().trim().toLowerCase();
    }

    private boolean shouldMoveToNextRoom(String answer) {
        return answer.equals("yes") || answer.equals("y");
    }

    private void navigateToNextRoom(Room room) {
        RoomNavigator navigator = Game.getGameEngine().getRoomNavigator();
        int index = Game.getRooms().indexOf(room);
        navigator.setCurrentRoomIndex(index);
        navigator.goToNextRoom();
    }

    private void handleDefeat() {
        System.out.println("You have been slain by " + monster.getName() + "!");
        System.out.println("Game Over.");
    }

    public void startBattle(Room room, Player player) {
        displayBattleStart();
        runBattle(room, player);
    }

    private void displayBattleStart() {
        System.out.println();
        player.printStatus();
        System.out.println(monster.getHealthPoints());
        System.out.println();
        System.out.println("You are now in battle!");
    }
}