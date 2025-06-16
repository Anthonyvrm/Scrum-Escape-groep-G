package PlayerCreation;

import Joker.*;
import classes.Player;

import java.util.Scanner;

public class PlayerSelectsJoker {

    // Ask Player to choose Joker, set joker on player.
    public void selectJoker(Player player) {
        Scanner scanner = new Scanner(System.in);

        Joker selectedJoker = null;

        System.out.println("Choose your joker for the game:");
        System.out.println("1. Hint Joker - Shows a hint in any room");
        System.out.println("2. Key Joker - Gives an extra key in Daily Scrum and Review Room");
        System.out.println("3. Skip - Don't choose a Joker");

        // Loop until the joker has been selected or skipped.
        while (selectedJoker == null) {
            System.out.print("Enter your choice (1, 2 or 3): ");

            // Check if input is an integer.
            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a number.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();

            // Handle the player's choice
            switch (choice) {
                case 1 -> {
                    selectedJoker = new HintJoker();
                    System.out.println();
                    System.out.println("You selected the Hint Joker!");
                }
                case 2 -> {
                    selectedJoker = new KeyJoker();
                    System.out.println();
                    System.out.println("You selected the Key Joker!");
                }
                case 3 -> {
                    System.out.println();
                    System.out.println("You chose not to use a joker!"); //Joker == null!
                }
                default -> System.out.println("Invalid input! Please choose 1, 2 or 3.");
            }

            if (choice == 3) break; //Choice is not to take a joker, so the game continues without one.
        }

        // Set joker on player.
        player.setJoker(selectedJoker);
        System.out.println();
    }
}
