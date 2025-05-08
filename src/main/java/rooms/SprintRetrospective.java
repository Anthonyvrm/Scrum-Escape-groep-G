package rooms;

import classes.Monster; //Monster stagnator: does not learn from mistakes
import classes.Room;
import monster.ScopeCreep;

public class SprintRetrospective extends Room {
    public static Room sprintRetrospectiveRoom;
    public SprintRetrospective(String question, String object, String name, Monster monster) {
        super(question, object, name, monster);
    }

    public static void createRoom(){
        Monster scopeCreep = new ScopeCreep(10, 50);
        sprintRetrospectiveRoom = new SprintRetrospective("Question", "Objective", "Sprint Planning Room", scopeCreep);
    }
}
