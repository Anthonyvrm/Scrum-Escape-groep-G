package classes;

public class StatusObserver implements Observer {
    private Player player;

    public StatusObserver(Player player) {
        this.player = player;
    }

    @Override
    public void update(boolean isCorrect) {
        System.out.printf("Status: %s | HP: %d | Locatie: %s\n",
                player.getName(),
                player.getStatus(),
                player.getPosition().name
        );
        if (!isCorrect) {
            System.out.println("Wrong answer! look at your HP and Try again.");
        }
    }
}
