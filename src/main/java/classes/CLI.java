package classes;

import monster.ScopeCreep;
import rooms.ScrumBoard;

public class CLI {
    public static void CLI() {

        Game game = new Game();
        game.startGame();

        Player player = new Player();

        player.createCharacter();

        player.showStartPlayerInfo();

    }

}

