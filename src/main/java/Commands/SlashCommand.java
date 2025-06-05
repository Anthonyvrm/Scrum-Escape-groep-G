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

        int roll = new Random().nextInt(20);

        System.out.println("You slash your foe with your sword!");
        System.out.println("You rolled a " + roll + " on the dice.");

        int damage = switch (roll) {
            case 19 -> {
                System.out.println("Critical hit!");
                yield 5;
            }
            default -> (roll >= 5) ? 2 : 0;
        };

        if (damage > 0) {

            monster.takeDamage(damage);
            System.out.println("The foe took " + damage + " damage!");

        } else {

            System.out.println("You missed!");
        }

        System.out.println("The foe's HP is now " + monster.getHealthPoints());

        monster.dealDamage(player, 10);

        System.out.println("Your HP is now " + player.getStatus());
    }
}
