package classes;

import Game.Game;
import Observers.DeurObserver;
import Observers.MonsterObserver;
import Observers.StatusObserver;
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


        // Create player
        Player player = PlayerCreation.createCharacter();

        Room sprintPlanning = new SprintPlanning(scopeCreep, false, player); ////WAAH
        Room scrumBoard = new ScrumBoard(trollo, false, player);// we zijn echt te diep in dir project ik weet echt neit meer hoe dingen werken, fuck it neef // geen idee
        Room theDailyScrum = new TheDailyScrum(slowness, false, player);// facts
        Room sprintReview = new SprintReview(feedbackPhantom, false, player);
        Room sprintRetrospective = new SprintRetrospective(stagnator, false, player);
        Room tiaRoom = new TIARoom(theScrumReaper, false, player);

        List<Room> allRooms = new ArrayList<>(List.of(
                sprintPlanning,
                theDailyScrum,
                scrumBoard,
                sprintReview,
                sprintRetrospective,
                tiaRoom
        ));

        for (Room room : allRooms) {
            room.setPlayer(player);
        }

        // Register observers for each room
        for (Room room : allRooms) {
            room.registerObserver(new DeurObserver(room));
            room.registerObserver(new MonsterObserver(room.monster, player, room));
            room.registerObserver(new StatusObserver(player, room));
        }

        // Create main game instance
        Game game = new Game(player);
        game.setRooms(allRooms);

        // Start the game with the first room
        game.startGame(allRooms.getFirst());
    }
}


