package Commands;

import Interface.Command;
import classes.Monster;
import classes.Player;
import java.util.Random;

public class SlashCommand implements Command {
    private final Player player;
    private final Monster monster;

    public SlashCommand(Player player, Monster monster) {
        this.player = player;
        this.monster = monster;
    }

    @Override
    public void execute() {
        Random rand = new Random();
        System.out.println("You slash your foe with your sword!");
        int chance = rand.nextInt(20);
        if (chance >= 10) {
            monster.takeDamage(2);
            System.out.println("The foe took 2 damage!");
            System.out.println("The foe's HP is now " + monster.getHealthPoints());


        } else if (chance == 10) {
            System.out.println("Critical hit!");
            monster.takeDamage(5);
            System.out.println("The foe took 5 damage!");
            System.out.println("The foe's HP is now " + monster.getHealthPoints());
        } else {
            System.out.println("You missed!");
        }
    }
}


