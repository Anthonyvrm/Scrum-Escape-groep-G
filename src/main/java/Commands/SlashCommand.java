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

        System.out.println("You rolled a " + roll + " on the dice.");
        System.out.println();


        int damage = switch (roll) {
            case 19 -> {
                System.out.println("Critical hit!");
                System.out.println();
                yield 5;
            }
            default -> (roll >= 5) ? 2 : 0;
        };

        if (damage > 0) {

            System.out.println(player.getName() + " attacks " + monster.getName());
            System.out.println(monster.getName()+  " took " + damage + " damage!");
            monster.takeDamage(damage);

        } else {

            System.out.println("You missed!");
        }

        System.out.println();
        System.out.println(monster.getName() + " HP is : " + monster.getHealthPoints());

        //! hier gaat het nog fout, de monster doet damage wanneer die ook dood is.
        //! + hij doet altijd 10 dmg.

        System.out.println();
        System.out.println(monster.getName() + " attacks you and does 10 damage!");

        monster.dealDamage(player, 10);

        System.out.println(player.getName() + " HP is : " + player.getStatus());

        System.out.println();
    }
}
