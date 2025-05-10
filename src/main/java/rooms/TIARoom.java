package rooms;

import classes.Monster; //The Scrum Reaper
import classes.Room;
import monster.ScopeCreep;

public class TIARoom extends Room {
    public static Room TIARoomRoom;
    public TIARoom (String question, String object, String name, Monster monster) {
        super(question, object, name, monster);
    }

    public TIARoom(String question, String objective, String sprintPlanningRoom) {
        super(question, objective, sprintPlanningRoom);
    }

    public static void createRoom(){
        TIARoomRoom = new TIARoom("Question", "Objective", "Sprint Planning Room");
    }
}
