package Initializers;

import Observers.DeurObserver;
import Observers.MonsterObserver;
import Observers.StatusObserver;
import classes.Monster;
import classes.Player;
import classes.Room;
import monster.*;
import rooms.*;

import java.util.List;

public class InitializeRooms {

    static List<Room> createRoomsInOrder(Player player) {
        // Create monsters
        Monster scopeCreep = new Monster(1, 10, "Scope Creep", new ScopeCreep());
        Monster slowness = new Monster(1, 10, "Slowness", new Slowness());
        Monster trollo = new Monster(1, 10, "Trollo", new Trollo());
        Monster feedbackPhantom = new Monster(1, 10, "Feedback Phantom", new FeedbackPhantom());
        Monster stagnator = new Monster(1, 10, "Stagnator", new Stagnator());
        Monster theScrumReaper = new Monster(1, 25, "Scrum Reaper", new TheScrumReaper());

        // Create and return rooms in the required order
        return List.of(
                new SprintPlanning(scopeCreep, false, player),
                new TheDailyScrum(slowness, false, player),
                new ScrumBoard(trollo, false, player),
                new SprintReview(feedbackPhantom, false, player),
                new SprintRetrospective(stagnator, false, player),
                new TIARoom(theScrumReaper, false, player)
        );
    }

    static void registerObservers(List<Room> rooms, Player player) {
        for (Room room : rooms) {
            room.setPlayer(player);
            room.registerObserver(new DeurObserver(room));
            room.registerObserver(new MonsterObserver(room.monster, player, room));
            room.registerObserver(new StatusObserver(player, room));
        }
    }
}