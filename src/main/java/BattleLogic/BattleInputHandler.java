
package BattleLogic;

import Game.InputHandler;
import Interface.Command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BattleInputHandler {
    private final Map<String, Command> commands = new HashMap<>();
    private final Scanner scanner;
    protected ArrayList<String> availableCommands;

    public BattleInputHandler(Scanner scanner) {
        this.availableCommands = new ArrayList<>();
        this.scanner = scanner;
    }

    public void registerCommand(String commandName, Command command) {
        commands.put(commandName.toLowerCase(), command);
    }



    public void handleBattleInput() {
        InputHandler inputHandler = new InputHandler();
        inputHandler.handleInput(availableCommands, scanner, commands);
    }
}