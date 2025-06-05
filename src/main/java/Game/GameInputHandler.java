
package Game;

import Interface.Command;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameInputHandler {
    // Map that stores commands.
    private final Map<String, Command> commands = new HashMap<>();
    private final Scanner scanner;

    // A list of available command descriptions.
    protected ArrayList<String> availableCommands;

    // Constructor that initializes the input handler with a scanner anda list of available commands.
    public GameInputHandler(Scanner scanner) {
        this.availableCommands = new ArrayList<>();
        this.scanner = scanner;
    }

    //  Registers a command with a name.
    public void registerCommand(String commandName, Command command) {
        commands.put(commandName.toLowerCase(), command);
    }

    // Handles the user input.
    public void handleGameInput() {
        InputHandler inputHandler = new InputHandler();
        inputHandler.handleInput(availableCommands, scanner, commands);
    }
}