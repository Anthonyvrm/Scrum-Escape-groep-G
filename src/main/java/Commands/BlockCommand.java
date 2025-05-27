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
        Random random = new Random();
        int randomNumber = random.nextInt(20);
        int blockChance = randomNumber / 20;
        int finalDamage = blockChance - randomNumber;

        if (randomNumber > 10) {
            monster.dealDamage(player);
        }
        if (randomNumber == 0) {
            System.out.println("You failed to block the foe");
        }
        else {
            System.out.println("You block the foe, but it's too late!");
        }
    }
}



