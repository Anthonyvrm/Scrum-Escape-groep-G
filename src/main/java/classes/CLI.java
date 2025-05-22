package classes;

import StrategyClasses.MultipleChoiceQuestion;
import StrategyClasses.OpenQuestion;
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


        Room sprintPlanning = new Room("Sprint Planning Room", scopeCreep, false, new SprintPlanning());
        Room theDailyScrum = new Room("The Daily Scrum Room", slowness, false, new TheDailyScrum());
        Room scrumBoard = new Room("Scrumboard Room", trollo, false, new ScrumBoard());
        Room sprintReview = new Room("Sprint Review Room", feedbackPhantom, false, new SprintReview());
        Room sprintRetrospective = new Room("Sprint Retrospective Room", stagnator, false, new SprintRetrospective());
        Room tiaRoom = new Room("TIA Room", theScrumReaper, false, new TIARoom());

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
