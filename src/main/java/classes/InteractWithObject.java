package classes;

import Interface.*;
import Game.Game;
import java.util.Scanner;

public class InteractWithObject {
    private IReadable readableObject;
    private IWeapon weapon;
    private IRewardable reward;
    Scanner scanner = new Scanner(System.in);

    public InteractWithObject(IReadable readableObject, IWeapon weapon, IRewardable reward) {
        this.readableObject = readableObject;
        this.weapon = weapon;
        this.reward = reward;
    }

    public void displayOptions() {
        System.out.println("Available interactions:");
        if (readableObject != null) System.out.println(("- Book (read information about this room"));
        if (weapon != null) System.out.println("- Weapon (use in combat)");
        if (reward != null) System.out.println("- Reward (collect a reward)");
        System.out.println("- Exit (stop interacting)");
        System.out.println("What would you like to interact with?");
    }

    private void useReadable() {
        if (readableObject != null) {
            readableObject.showMessage();
        } else {
            System.out.println("There is no book in this room!");
        }
    }

    private void useWeapon() {
        if (weapon !=null ) {
            weapon.attack();
        } else {
            System.out.println("There is no weapon in this room!");
        }
    }

    private void useReward(Player player) {
        if (reward != null) {
            reward.grantReward(player);
        } else {
            System.out.println("There is no reward available in this room!");
        }
    }

    public void interactWithObject(Player player) {
        if (readableObject == null && weapon == null && reward == null) {
            System.out.println("There are no objects in this room!");
            return;
        }
            displayOptions();
            String input = scanner.nextLine().trim().toLowerCase();

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




