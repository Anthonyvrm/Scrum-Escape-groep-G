
package BattleLogic;

import Game.InputHandler;
import Interface.Command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BattleInputHandler {
    // Stores commands.
    private final Map<String, Command> commands = new HashMap<>();
    private final Scanner scanner;

    // List of battle command descriptions.
    protected ArrayList<String> availableCommands;

    // Constructor, which initializes an available commands list and scanner.
    public BattleInputHandler(Scanner scanner) {
        this.availableCommands = new ArrayList<>();
        this.scanner = scanner;
    }

    // Register new command.
    public void registerCommand(String commandName, Command command) {

        commands.put(commandName.toLowerCase(), command);

    }


    // Handle player's battle input.
    public void handleBattleInput() {

        InputHandler inputHandler = new InputHandler();

        inputHandler.handleInput(availableCommands, scanner, commands);

    }
}