package Commands;

import Interface.Command;
import classes.Monster;
import classes.Player;
import java.util.Random;

public class BlockCommand implements Command {
    private final Player player;
    private final Monster monster;

    public BlockCommand(Player player, Monster monster) {
        this.player = player;
        this.monster = monster;
    }

    @Override
    public void execute() {
        int roll = new Random().nextInt(20);
        double modifier = roll == 0 ? 1.0 : roll == 19 ? 0.0 : 1.0 - (roll / 19.0);

        System.out.println("You rolled a " + roll + " on the dice.");
        System.out.println(switch (roll) {
            case 0 -> "Block failed! You take full damage.";
            case 19 -> "Perfect block! You take zero damage.";
            default -> "You block the foe, but it's too late, you've taken damage!";
        });

        monster.dealDamage(player, 10 * modifier);
        System.out.println("Your HP is now " + player.getStatus());

        int counterDamage = switch (roll) {
            case 19 -> 4;
            case 15, 16, 17, 18 -> 2;
            case 0 -> 0;
            default -> 1;
        };

        if (counterDamage > 0) {
            monster.takeDamage(counterDamage);
            System.out.println("You have countered the monster and deal " + counterDamage + " damage!");
        } else {
            System.out.println("You missed!");
        }

        System.out.println("The foe's HP is now: " + monster.getHealthPoints());
    }
}
