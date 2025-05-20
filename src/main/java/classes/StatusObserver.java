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
        System.out.printf("Name: %s | HP: %d | Locatie: %s\n",
                player.getName(),
                player.getStatus(),
                player.getPosition().name


        );
        if (!isCorrect) {
            System.out.println("Wrong answer! look at your HP and Try again.");
            //room.roomFeedback();
        }
    }
}
