package classes;

import Interface.IWeapon;

public class Weapon implements IWeapon {

    // Action when the player wants to use a weapon.
    @Override
    public void attack() {
        //Misschien nog logica dat je meer damage doet als je het wapen meeneemt?
        //Kunnen ook specifieke wapens in elke kamer aanmaken met andere damage.

        System.out.println("You picked up a weapon!");
    }
}