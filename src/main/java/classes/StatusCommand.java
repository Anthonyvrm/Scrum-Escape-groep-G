package classes;

public class StatusCommand implements Command {
    private final Player player;

    public StatusCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.printStatus();
    }
}

