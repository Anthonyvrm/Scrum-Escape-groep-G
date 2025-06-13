package classes;

import Interface.IRewardable;
import java.util.Random;

public class RoomReward implements IRewardable {
    // Grants the player a reward when this method is called.
    @Override
    public void grantReward(Player player) {

        int healthPoints = new Random().nextInt(5, 15);
        player.setStatus(player.getStatus() + healthPoints);
        System.out.println("You found a health potion! + " + healthPoints + " HP");
        System.out.println("Current health: " + player.getStatus());
    }
}