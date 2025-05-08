package rooms;

import classes.Monster;
import classes.Room;
import monster.ScopeCreep;

public class ScrumBoard extends Room {
    public static Room scrumBoardRoom;
    public ScrumBoard (String question, String objective, String name, Monster monster ) {
        super(question, objective, name, monster);
    }
    public ScrumBoard(String question, String objective, String name) {
        super(question, objective, name);
    }

    public static void createRoom(){
        Monster scopeCreep = new ScopeCreep(10, 50);
        scrumBoardRoom = new ScrumBoard("Question", "Objective", "Sprint Planning Room", scopeCreep);
    }
}
