package classes;

public class StatusObserver implements Observer {
    Player player;

    public StatusObserver(Player player) {
        this.player = player;
    }

    @Override
    public void update(boolean isCorrect) {
        System.out.printf("Name: %s, Health: %d, Position: %s\n", player.getName(), player.getStatus(), player.getPosition());
    }
}