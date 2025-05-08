package rooms;

import classes.Monster;
import classes.Room;
import monster.ScopeCreep;

public class SprintPlanning extends Room {
    public static Room sprintPlanningRoom;
    public SprintPlanning(String question, String objective, String name, Monster monster){
        super(question, objective, name, monster);
    }

    public static void createSprintPlanningRoom () {

        Monster scopeCreep = new ScopeCreep(10, 50);
        sprintPlanningRoom = new SprintPlanning("Question", "Objective", "Sprint Planning Room", scopeCreep);

    }



}
