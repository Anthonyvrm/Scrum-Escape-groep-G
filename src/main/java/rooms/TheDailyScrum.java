package rooms;

import classes.Monster; //Slowness
import classes.Room;
import monster.ScopeCreep;

public class TheDailyScrum extends Room {
    public static Room theDailyScrumRoom;
    public TheDailyScrum(String question, String objective, String name, Monster monster) {
        super(question, objective, name, monster);
    }

    public static void createRoom(){
        Monster scopeCreep = new ScopeCreep(10, 50);
        theDailyScrumRoom = new TheDailyScrum("Question", "Objective", "Sprint Planning Room", scopeCreep);
    }
}
