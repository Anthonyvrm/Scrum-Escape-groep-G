package Observers;

import Interface.QuestionObserver;
import classes.Player;
import classes.Room;

public class StatusObserver implements QuestionObserver {
    private final Player player;
    private final Room room;

    // Constructor StatusObserver.
    public StatusObserver(Player player, Room room) {
        this.player = player;
        this.room = room;
    }

    // Called when the question's answer is updated.
    @Override
    public void update(boolean isCorrect) {

        if (!isCorrect) {
            // If the answer is incorrect, reduce player's hp by 5 and notify the player.
            player.setStatus(player.getStatus() - 5);

            System.out.println("The monster has decreased your HP by 5.");
            System.out.printf("Your HP is now %d.\n", player.getStatus());

            //!room.roomFeedback();
        }
    }
}