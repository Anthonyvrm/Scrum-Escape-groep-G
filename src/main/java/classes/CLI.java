package classes;

import monster.ScopeCreep;
import rooms.ScrumBoard;

public class CLI {
    public static void main(String[] args) {
        Player player = new Player(1,"s");
        Room room = new ScrumBoard("Scrum Board", "This is the scrum board", "Scrum Board");
        Game game = new Game(room, player);
        game.StartGame();

    }

}

