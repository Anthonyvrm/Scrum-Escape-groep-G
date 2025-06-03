package Game;

import Interface.Command;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class InputHandler {
        public void handleInput(ArrayList<String> availableCommands, Scanner scanner, Map<String, Command> commands) {
        System.out.println();
        System.out.println("Available commands:");
        for(String useableCommand : availableCommands) {
            System.out.println(useableCommand);
        }
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
