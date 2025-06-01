package Commands;

import Game.GameUI;
import Interface.Command;
import classes.Player;

public class JokerCommand implements Command {
    private final Player player;
    private final GameUI gameUI;

    public JokerCommand(Player player, GameUI gameUI) {
        this.player = player;
        this.gameUI = gameUI;
    }

    @Override
    public void execute() {
        if (player.getJoker() != null) {
            player.getJoker().useJokerIn(player.getPosition());
        } else {
            gameUI.showMessage("You have no joker available!");
        }
    }
}

