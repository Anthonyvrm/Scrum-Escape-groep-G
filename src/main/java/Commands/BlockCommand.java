package Commands;

import Interface.Command;
import classes.Monster;
import classes.Player;
import java.util.Random;

// Allows the player to block an attack and counterattack the monster.
public class BlockCommand implements Command {
    private final Player player;
    private final Monster monster;

    // Constructor for BlockCommand.
    public BlockCommand(Player player, Monster monster) {
        this.player = player;
        this.monster = monster;
    }

    // Executes block command.
    @Override
    public void execute() {
        Random random = new Random();

        // Roll dice 0-19.
        int diceRoll = random.nextInt(20);
        double damageModifier;

        // Used to reduce damage.
        double blockDamage = (double) diceRoll / 19;
        System.out.println("You rolled a " + diceRoll + " on the dice.");

        // Determine the outcome of the block based on the dice roll.
        if (diceRoll == 0) {
            damageModifier = 1.0;
            System.out.println("Block failed! You take full damage.");
        }
        else if (diceRoll == 19){
            damageModifier = 0.0;
            System.out.println("Perfect block! You take zero damage.");
        }
        else {
            // Blockdamage reduces more damage by getting a higher dice roll.
            damageModifier = 1.0 - blockDamage;
            System.out.println("You block the foe, but it's too late, you've taken damage!");
        }
        // Apply damage to player based on modifier (base damage is 10).
        monster.dealDamage(player, 10 * damageModifier);
        System.out.println("Your HP is now " + player.getStatus());

        // Determine the outcome of the counterattack based on the dice roll
        if (diceRoll == 19) {
            monster.takeDamage(4);
            System.out.println("You have countered the monster and deal 4 damage!");
            System.out.println("The foe's HP is now: " + monster.getHealthPoints());
        }
        else if (diceRoll >= 15) {
            monster.takeDamage(2);
            System.out.println("You have countered the monster and deal 2 damage!");
            System.out.println("The foe's HP is now: " + monster.getHealthPoints());

        }
        else if (diceRoll == 0) {
            System.out.println("You missed!");
            System.out.println("The foe's HP is still: " + monster.getHealthPoints());
        }
        else {
            monster.takeDamage(1);
            System.out.println("You have countered the monster and deal 1 damage!");
            System.out.println("The foe's HP is now: " + monster.getHealthPoints());
        }
    }
}



