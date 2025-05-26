package classes;

import java.util.List;

public class GameEngine {
    private final Player player;
    private final GameUI gameUI;
    private final GameInputHandler inputHandler;
    private final RoomNavigator roomNavigator;
    private List<Room> rooms;

    public GameEngine(Player player, List<Room> rooms) {
        this.player = player;
        this.gameUI = new GameUI();
        this.inputHandler = new GameInputHandler(new java.util.Scanner(System.in));
        this.roomNavigator = new RoomNavigator(rooms, player, gameUI);
        setupCommands();
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
        this.roomNavigator.setRooms(rooms);
        setupCommands();
    }

    private void setupCommands() {
        inputHandler.registerCommand("go to next", new NextRoomCommand(roomNavigator, player));
        inputHandler.registerCommand("status", new StatusCommand(player));
    }

    public void startGame() {
        gameUI.showGameTitle();
        gameUI.showStartingDialogue(player.getName());

        Room startingRoom = roomNavigator.getCurrentRoom();
        player.setPosition(startingRoom);
        startingRoom.runEscapeRoom();

        runGameLoop();
    }

    private void runGameLoop() {
        while (true) {
            inputHandler.handleInput();
        }
    }
}

