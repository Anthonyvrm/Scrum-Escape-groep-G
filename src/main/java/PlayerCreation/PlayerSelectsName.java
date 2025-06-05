package PlayerCreation;

import classes.Player;

import java.util.Scanner;

public class PlayerSelectsName {

    // Ask the Player to enter their name and add it to the player object.
    public void whatIsYourName(Player player) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("What is your name: ");

        String name = scanner.nextLine();

        player.setName(name);

        System.out.println();
    }
}
