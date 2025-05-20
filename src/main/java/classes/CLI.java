package classes;

import monster.*;
import rooms.*;
import monster.ScopeCreep;
import rooms.ScrumBoard;
import rooms.SprintPlanning;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CLI {
    public static void CLI() {

        Player player = StartGame.createCharacter();


        Monster feedbackPhantom = new Monster(1, 10, "Feedback Phantom", new FeedbackPhantom());
        Monster scopeCreep = new Monster(1, 10, "Scope Creep", new ScopeCreep());
        Monster slowness = new Monster(1, 10, "Slowness", new Slowness());
        Monster stagnator = new Monster(1, 10, "Stagnator", new Stagnator());
        Monster trollo = new Monster(1, 10, "Trollo", new Trollo());
        Monster theScrumReaper = new Monster (1, 25, "Scrum Reaper", new TheScrumReaper());

        Room sprintPlanning = new SprintPlanning("Sprint Planning Room", scopeCreep, false);
        Room theDailyScrum = new TheDailyScrum("The Daily Scrum Room", slowness, false);
        Room scrumBoard = new ScrumBoard("Scrumboard Room", trollo, false);
        Room sprintReview = new SprintReview("Sprint Review Room", feedbackPhantom, false);
        Room sprintRetrospective = new SprintRetrospective("Sprint Retrospective Room", stagnator, false);
        Room tiaRoom = new TIARoom("TIA Room", theScrumReaper, false);

// vaste volgorde van kamers ik word gek btw
        List<Room> allRooms = new ArrayList<>(List.of(
                sprintPlanning,
                theDailyScrum,
                scrumBoard,
                sprintReview,
                sprintRetrospective,
                tiaRoom
        ));


        Game game = new Game(player);
        game.setRooms(allRooms);

// enge for loop voor de obervererers
        for (Room room : allRooms) {
            room.registerObserver(new DeurObserver(room));
            room.registerObserver(new MonsterObserver(room.monster));
            room.registerObserver(new StatusObserver(player, room));
        }

        game.startGame(allRooms.get(0));
    }

}
