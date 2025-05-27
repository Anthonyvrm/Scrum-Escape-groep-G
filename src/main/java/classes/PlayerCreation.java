package classes;

import Game.GameUI;
import Joker.*;

import java.util.Scanner;

public class PlayerCreation {
    public static Player createCharacter() {
        GameUI.showGameTitle();
        Player player = new Player();
        System.out.println("Starting Character Creation...");
        System.out.println();
        System.out.println("Create your character!");
        System.out.println();
        whatIsYourName(player);
        selectJoker(player);
        player.setStatus(150);
        return player;
    }

    public static void whatIsYourName(Player player) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("What is your name: ");
        String name = scanner.nextLine();
        player.setName(name);

        System.out.println();
    }

    private static void selectJoker(Player player) {
        Scanner scanner = new Scanner(System.in);
        Joker selectedJoker = null;

        System.out.println("Choose your joker for the game:");
        System.out.println("1. Hint Joker - Shows a hint in any room");
        System.out.println("2. Key Joker - Gives an extra key in Daily Scrum and Review Room");

        while (selectedJoker == null) {
            System.out.print("Enter your choice (1, 2 or 3): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a number.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    selectedJoker = new HintJoker();
                    System.out.println("You selected the Hint Joker!");
                }
                case 2 -> {
                    selectedJoker = new KeyJoker();
                    System.out.println("You selected the Key Joker!");
                }
                case 3 -> {
                    System.out.println("You chose not to use a joker!"); //Joker == null!
                }
                default -> System.out.println("Invalid input! Please choose 1, 2 or 3.");
            }

            if (choice == 3) break; //Choice is not to take a joker, so the game continues without
        }

        player.setJoker(selectedJoker);
        System.out.println();
    }
}