package classes;

import monster.*;
import rooms.*;
import java.util.ArrayList;
import java.util.List;

public class CLI {
    public static void CLI() {

        // Create monsters
        Monster feedbackPhantom = new Monster(1, 10, "Feedback Phantom", new FeedbackPhantom());
        Monster scopeCreep = new Monster(1, 10, "Scope Creep", new ScopeCreep());
        Monster slowness = new Monster(1, 10, "Slowness", new Slowness());
        Monster stagnator = new Monster(1, 10, "Stagnator", new Stagnator());
        Monster trollo = new Monster(1, 10, "Trollo", new Trollo());
        Monster theScrumReaper = new Monster(1, 25, "Scrum Reaper", new TheScrumReaper());

        // Create rooms
        Room sprintPlanning = new SprintPlanning(scopeCreep, false);
        Room scrumBoard = new ScrumBoard(trollo, false);
        Room theDailyScrum = new TheDailyScrum(slowness, false);
        Room sprintReview = new SprintReview(feedbackPhantom, false);
        Room sprintRetrospective = new SprintRetrospective(stagnator, false);
        Room tiaRoom = new TIARoom(theScrumReaper, false);



        // Create room list
        List<Room> allRooms = new ArrayList<>(List.of(
                sprintPlanning,
                theDailyScrum,
                scrumBoard,
                sprintReview,
                sprintRetrospective,
                tiaRoom
        ));

        // Create player
        Player player = PlayerCreation.createCharacter();

        // Register observers for each room
        for (Room room : allRooms) {
            room.registerObserver(new DeurObserver(room));
            room.registerObserver(new MonsterObserver(room.monster));
            room.registerObserver(new StatusObserver(player, room));
        }



        // Create main game instance
        Game game = new Game(player);
        game.setRooms(allRooms);

        // Start the game with the first room
        game.startGame(allRooms.getFirst());
    }
}


