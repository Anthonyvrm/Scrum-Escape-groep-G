package Commands;

import Interface.Command;
import classes.Monster;
import classes.Player;
import java.util.Random;

// Command player slashing monster.
public class SlashCommand implements Command {
    private final Player player;
    private final Monster monster;

    // Constructor SlashCommand.
    public SlashCommand(Player player, Monster monster) {
        this.player = player;
        this.monster = monster;
    }

    @Override
    public void execute() {
        Random rand = new Random();
        System.out.println("You slash your foe with your sword!");
        // Rolls a random number between 0 and 19 to determine attack outcome.
        int chance = rand.nextInt(20);
        // If the roll is between 5 and 18, the monster takes 2 damage.
        if (chance >= 5 && chance <= 18) {
            monster.takeDamage(2);
            System.out.println("The foe took 2 damage!");
            System.out.println("The foe's HP is now " + monster.getHealthPoints());
            monster.dealDamage(player, 10);
            System.out.println("Your hp is now " + player.getStatus());


        // Monster gets 5 damage when dice roll is 19.
        } else if (chance == 19) {
            System.out.println("Critical hit!");
            monster.takeDamage(5);
            System.out.println("The foe took 5 damage!");
            System.out.println("The foe's HP is now " + monster.getHealthPoints());
            monster.dealDamage(player, 10);
            System.out.println("Your hp is now " + player.getStatus());

            // Dice roll lower than 5 is a miss.
        } else {
            System.out.println("You missed!");
            monster.dealDamage(player, 10);
            System.out.println("Your hp is now " + player.getStatus());
        }
    }
}


