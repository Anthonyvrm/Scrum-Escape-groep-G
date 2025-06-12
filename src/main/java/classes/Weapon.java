package classes;

import Interface.IWeapon;

public class Weapon implements IWeapon {
    // Action when the player wants to use a weapon.
    @Override
    public void attack(Monster monster) {
        System.out.println("You picked up a weapon!");
        System.out.println("You hit the monster for half of its health");
        monster.setHealthPoints(monster.getHealthPoints() / 2);
    }
}