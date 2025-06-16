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
        //rolls a dice with 20 sides
        int roll = new Random().nextInt(20);

        System.out.println("You rolled a " + roll + " on the dice.");
        System.out.println();

        //calculates damage
        int damage = switch (roll) {
            case 19 -> {
                System.out.println("Critical hit!");
                System.out.println();
                yield 5;
            }
            case 18 -> {
                System.out.println("Great hit!");
                System.out.println();
                yield 4;
            }
            case 17 -> {
                System.out.println("Good hit!");
                System.out.println();
                yield 3;
            }

            default -> (roll >= 5) ? 2 : 0;
        };

        //deals damage to the monster
        if (damage > 0) {
            System.out.println(player.getName() + " attacks " + monster.getName());
            System.out.println(monster.getName()+  " took " + damage + " damage!");
            monster.takeDamage(damage);
        } else {
            System.out.println("You missed!");
        }

        //prints the new monster's HP'
        System.out.println();

        if (monster.getHealthPoints() < 0) {
            System.out.println(monster.getName() + " HP is : " + 0);
        } else {
            System.out.println(monster.getName() + " HP is : " + monster.getHealthPoints());
        }

        //deals damage to the player if the monster is still alive
        if (monster.getHealthPoints() >= 0) {
            System.out.println();
            System.out.println(monster.getName() + "attacks you with " + monster.getDamage() + " damage!");

            monster.dealDamage(player, 1);
            System.out.println();
        }

        //prints the new player's HP'
        System.out.println(player.getName() + " HP is : " + player.getStatus());
        System.out.println();
    }
}
