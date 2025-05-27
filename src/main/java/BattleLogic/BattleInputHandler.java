
package BattleLogic;

import Interface.Command;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BattleInputHandler {
    private final Map<String, Command> commands = new HashMap<>();
    private final Scanner scanner;

    public BattleInputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public void registerCommand(String commandName, Command command) {
        commands.put(commandName.toLowerCase(), command);
    }

    public void handleInput() {
        System.out.println();
        System.out.println("Available commands:");
        System.out.println("Attack");
        System.out.println("Block");
        System.out.print("> ");

        String input = scanner.nextLine().trim().toLowerCase();
        Command command = commands.get(input);

        if (command != null) {
            command.execute();
        } else {
            System.out.println("Unknown command");
        }
    }
}

