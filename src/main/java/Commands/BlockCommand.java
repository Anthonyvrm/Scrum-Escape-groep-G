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
        int diceRoll = random.nextInt(20);
        double damageModifier;
        double blockDamage = (double) diceRoll / 19;

        if (diceRoll == 0) {
            damageModifier = 1.0;
            System.out.println("Block failed! You take full damage.");
            System.out.println("Your HP is now " + player.getStatus());
        }
        else if (diceRoll == 19){
            damageModifier = 0.0;
            System.out.println("Perfect block! You take zero damage.");
            System.out.println("Your HP is still " + player.getStatus());
        }
        else {
            damageModifier = 1.0 - blockDamage;
            System.out.println("You block the foe, but it's too late, you've taken damage!");
            System.out.println("Your HP is now " + player.getStatus());
        }
        monster.dealDamage(player, damageModifier);
    }
}



