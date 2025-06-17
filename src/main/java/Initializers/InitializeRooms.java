package Initializers;

import Assistent.AssistantAction;
import Assistent.AssistantActivator;
import Observers.DeurObserver;
import Observers.MonsterObserver;
import Observers.StatusObserver;
import classes.Monster;
import classes.Player;
import classes.Room;
import monster.*;
import rooms.*;

import java.util.ArrayList;
import java.util.List;

public class InitializeRooms {

    static List<Room> createRoomsInOrder(Player player) {
        // Create monsters
        Monster scopeCreep = new Monster(1, 10, "Scope Creep", new ScopeCreep(), MonsterAscii.scopeCreepAscii());
        Monster slowness = new Monster(1, 10, "Slowness", new Slowness(), MonsterAscii.slownessAscii());
        Monster trollo = new Monster(2, 10, "Trollo", new Trollo(), MonsterAscii.trolloAscii());
        Monster feedbackPhantom = new Monster(3, 10, "Feedback Phantom", new FeedbackPhantom(), MonsterAscii.feedbackPhantomAscii());
        Monster stagnator = new Monster(4, 10, "Stagnator", new Stagnator(), MonsterAscii.stagnatorAscii());
        Monster theScrumReaper = new Monster(6,    20, "Scrum Reaper", new TheScrumReaper(), MonsterAscii.theScrumReaperAscii());


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