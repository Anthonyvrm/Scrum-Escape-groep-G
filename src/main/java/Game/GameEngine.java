package Game;

import Commands.JokerCommand;
import Commands.NextRoomCommand;
import Commands.StatusCommand;
import Joker.*;
import classes.*;

import java.util.List;
import java.util.Scanner;

public class GameEngine {
    private final Player player;
    private final GameUI gameUI;
    private final GameInputHandler inputHandler;
    private final RoomNavigator roomNavigator;

    // Constructor to initialize the game engine with a player, UI, input handler, and room navigator and a list of rooms.
    public GameEngine(Player player, List<Room> rooms) {
        this.player = player;
        this.gameUI = new GameUI();
        this.inputHandler = new GameInputHandler(new java.util.Scanner(System.in));
        this.roomNavigator = new RoomNavigator(rooms, player, gameUI);
        //setupCommands();
    }

    public RoomNavigator getRoomNavigator() {
        return roomNavigator;
    }

    public void setRooms(List<Room> rooms) {
        this.roomNavigator.setRooms(rooms);
        setupCommands();
    }

    // Registers commands the player can use and descriptions.
    private void setupCommands() {

        inputHandler.registerCommand("1", new NextRoomCommand(roomNavigator, player));

        inputHandler.registerCommand("2", new StatusCommand(player));

        inputHandler.availableCommands.add("- 1: Move to the next room");

        inputHandler.availableCommands.add("- 2: Check your current status");
        //inputHandler.registerCommand("joker", new JokerCommand(player, gameUI));
    }

    // Starts the game.
    public void startGame() {

        GameUI.showGameTitle();
        gameUI.showStartingDialogue(player.getName());

        // Set and enter the first room
        Room startingRoom = roomNavigator.getCurrentRoom();
        player.setPosition(startingRoom);
        startingRoom.runEscapeRoom();

        // Start game loop.
        runGameLoop();
    }

    // Runs game loop and waits for player commands.
    private void runGameLoop() {
        while (true) {
            inputHandler.handleGameInput();
        }
    }
}


