package classes;

import monster.ScopeCreep;
import rooms.ScrumBoard;
import rooms.SprintPlanning;

import java.util.Scanner;

public class CLI {
    public static void CLI() {

        Player player = new Player();
        player.createCharacter();

        Game game = new Game(player);
        game.startGame();








    }

}

