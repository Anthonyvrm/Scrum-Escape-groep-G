package InteractWithObject;

import Interface.IReadable;
import Interface.IRewardable;
import Interface.IWeapon;
import classes.Player;

import java.util.Scanner;

public class DisplayOptions {

    private final IReadable readableObject;
    private final IWeapon weapon;
    private final IRewardable reward;

    public DisplayOptions(IReadable readableObject, IWeapon weapon, IRewardable reward) {
        this.readableObject = readableObject;
        this.weapon = weapon;
        this.reward = reward;
    }

    //Displays the options for players InteractableObject.

    public void displayOptions() {

        System.out.println("Available interactions:");

        if (readableObject != null) System.out.println(("- 1: Book (read information about this room"));

        if (weapon != null) System.out.println("- 2: Weapon (use in combat)");

        if (reward != null) System.out.println("- 3: Reward (collect a reward)");

        System.out.println("- 4: Exit (stop interacting)");

        System.out.println("What would you like to interact with?");
        System.out.println();
    }
}

