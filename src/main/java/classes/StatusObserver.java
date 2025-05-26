package classes;

public class StatusObserver implements QuestionObserver {
    private Player player;
    private Room room;

    public StatusObserver(Player player, Room room) {
        this.player = player;
        this.room = room;
    }

    @Override
    public void update(boolean isCorrect) {
        if (!isCorrect) {
            player.setStatus(player.getStatus() - 5);
            System.out.println("The monster has decreased your HP by 5.");
            System.out.printf("Your HP is now %d.\n", player.getStatus()
            );
            //!room.roomFeedback();
        }
    }
}