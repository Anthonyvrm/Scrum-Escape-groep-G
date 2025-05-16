package classes;

import monster.*;
import rooms.*;

import java.util.ArrayList;
import java.util.List;

public class CLI {
    public static void CLI() {
        Player player = new Player();
        player.createCharacter();


        Monster feedbackPhantom = new FeedbackPhantom(1, 10);
        Monster scopeCreep = new ScopeCreep(1, 10);
        Monster slowness = new Slowness(1, 10);
        Monster stagnator = new Stagnator(1, 10);
        Monster trollo = new Trollo(1, 10);
        Monster theScrumReaper = new TheScrumReaper(1, 25);


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
            room.registerObserver(new StatusObserver(player));
        }


        game.startGame(allRooms.get(0));
    }
}
