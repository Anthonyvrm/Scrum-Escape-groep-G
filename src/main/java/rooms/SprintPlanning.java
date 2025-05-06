package rooms;

import classes.Monster;
import classes.Room;
import monster.ScopeCreep;

public class SprintPlanning extends Room {
    public SprintPlanning(String question, String objective, String name, Monster monster){
        super(question, objective, name, monster);
    }

    public void createSprintPlanningRoom () {

        Monster scopeCreep = new ScopeCreep(10, 50);
        Room sprintPlanningRoom = new SprintPlanning("Question", "Objective", "Sprint Planning Room", scopeCreep);

    }



}
