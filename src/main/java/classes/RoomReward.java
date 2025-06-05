package classes;

import Interface.IRewardable;

public class RoomReward implements IRewardable {

    // Grants the player a reward when this method is called.
    @Override
    public void grantReward(Player player) {
        player.setStatus(player.getStatus() + 5);
        System.out.println("You found a health poition! +5 HP");
        System.out.println("Current health: " + player.getStatus());
    }
    
}
