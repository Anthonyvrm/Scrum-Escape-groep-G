package Game;

import Interface.Command;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class InputHandler {
        // Handle user input.
        public void handleInput(ArrayList<String> availableCommands, Scanner scanner, Map<String, Command> commands) {
        System.out.println();
        // Displays available commands
        System.out.println("Available commands:");
        for(String useableCommand : availableCommands) {
            System.out.println(useableCommand);
        }
        System.out.print("> ");

        // Read input and find command.
        String input = scanner.nextLine().trim().toLowerCase();
        Command command = commands.get(input);

        // If the commands exists execute it.
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Unknown command");
        }
    }
}
