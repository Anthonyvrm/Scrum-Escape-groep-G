package rooms;

import classes.Monster; //The Scrum Reaper
import classes.Room;
import monster.ScopeCreep;

public class TIARoom extends Room {
    public static Room TIARoomRoom;
    public TIARoom (String question, String object, String name, Monster monster) {
        super(question, object, name, monster);
    }
    public static void createRoom(){
        Monster scopeCreep = new ScopeCreep(10, 50);
        TIARoomRoom = new TIARoom("Question", "Objective", "Sprint Planning Room", scopeCreep);
    }
}
