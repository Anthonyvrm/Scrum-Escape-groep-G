package classes;

import java.util.Scanner;

public class StartGame {
    public static Player createCharacter() {
        Player player = new Player();
        System.out.println("Starting Character Creation...");
        System.out.println();
        System.out.println("Create your character!");
        System.out.println();
        whatIsYourName(player);
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
}
