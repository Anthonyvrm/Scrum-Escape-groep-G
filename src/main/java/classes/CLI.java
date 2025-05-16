package classes;

import monster.*;
import rooms.*;

import java.util.Scanner;

public class CLI {
    public static void CLI() {
        Player player = new Player();
        player.createCharacter();

        Monster[] monsters = {
                new FeedbackPhantom(1, 10),
                new ScopeCreep(1, 10),
                new Slowness(1, 10),
                new Stagnator(1, 10),
                new Trollo(1, 10),
                new TheScrumReaper(1, 25)
        };

        Room[] rooms = {
                new ScrumBoard("Scrumboard Room", monsters[4], false),
                new SprintPlanning("Sprint Planning Room", monsters[1], false),
                new SprintRetrospective("Sprint Retrospective Room", monsters[3], false),
                new SprintReview("Sprint Review Room", monsters[0], false),
                new TheDailyScrum("The Daily Scrum Room", monsters[2], false),
                new TIARoom("TIA Room", monsters[5], false)
        };

        for (Room room : rooms) {
            room.registerObserver(new DeurObserver(room));
            room.registerObserver(new MonsterObserver(room.monster));
            room.registerObserver(new StatusObserver(player));

        }

        Game game = new Game(player);
        game.startGame(rooms[1]);
    }
}