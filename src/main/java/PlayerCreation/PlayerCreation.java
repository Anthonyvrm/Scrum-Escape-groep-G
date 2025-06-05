package PlayerCreation;

import Game.GameUI;
import Joker.*;
import classes.Player;

import java.util.Scanner;

public class PlayerCreation {


    public static Player createCharacter() {

        PlayerSelectsJoker playerselectsjoker = new PlayerSelectsJoker();
        PlayerSelectsName playerselectsname = new PlayerSelectsName();

        GameUI.showGameTitle();

        Player player = new Player();

        System.out.println("Starting Character Creation...");
        System.out.println();
        System.out.println("Create your character!");
        System.out.println();

        // Ask player for their name.
        playerselectsname.whatIsYourName(player);

        // Let player select Joker.
        playerselectsjoker.selectJoker(player);

        // Set player hp.
        player.setStatus(150);

        // Return fully created player.
        return player;
    }

    // Ask the Player to enter their name and add it to the player object.
    public static void whatIsYourName(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("What is your name: ");
        String name = scanner.nextLine();
        player.setName(name);
        System.out.println();
    }
}

