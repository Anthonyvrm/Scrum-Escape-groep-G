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

        if (readableObject != null) System.out.println(("- Book (read information about this room"));

        if (weapon != null) System.out.println("- Weapon (use in combat)");

        if (reward != null) System.out.println("- Reward (collect a reward)");

        System.out.println("- Exit (stop interacting)");

        System.out.println("What would you like to interact with?");
    }
}

