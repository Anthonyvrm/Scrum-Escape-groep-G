package InteractWithObject;

import Interface.*;
import classes.Player;

import java.util.Scanner;

public class InteractWithObject {
    // Interfaces which belong each to a different interactable object.
    private final IReadable readableObject;
    private final IWeapon weapon;
    private final IRewardable reward;
    Scanner scanner = new Scanner(System.in);

    // Constructor which initializes interactable room objects.
    public InteractWithObject(IReadable readableObject, IWeapon weapon, IRewardable reward) {
        this.readableObject = readableObject;
        this.weapon = weapon;
        this.reward = reward;
    }

    // Handle book interaction.
    private void useReadable() {

        if (readableObject != null) {
            readableObject.showMessage();
        } else {
            System.out.println("There is no book in this room!");
        }
    }

    // Handle weapon interaction.
    private void useWeapon() {

        if (weapon !=null ) {
            weapon.attack();
        } else {
            System.out.println("There is no weapon in this room!");
        }
    }

    // Handle reward interaction.
    private void useReward(Player player) {

        if (reward != null) {
            reward.grantReward(player);
        } else {
            System.out.println("There is no reward available in this room!");
        }
    }

    // Handle player input interaction with objects.
    public void interactWithObject(Player player) {
        DisplayOptions displayOptions = new DisplayOptions(readableObject, weapon, reward);

        if (readableObject == null && weapon == null && reward == null) {

            System.out.println("There are no objects in this room!");

            return;
        }
            displayOptions.displayOptions();

        String input = scanner.nextLine().trim().toLowerCase();

            // The Player uses an object based on input.
            switch (input) {
                case "book":
                    useReadable();
                    break;
                case "weapon":
                    useWeapon();
                    break;
                    case "reward":
                    useReward(player);
                    break;
                    case "exit":
                        return;
                default:
                    System.out.println("Invalid input! urgh....");
            }
        }
    }




