package rooms;

import classes.IRoom;
import classes.Monster; //Scope Creep
import classes.Room;
import monster.ScopeCreep;

public class SprintPlanning extends Room implements IRoom {

    public static Room sprintPlanningRoom;

    public SprintPlanning(String question, String objective, String name, Monster monster){
        super(question, objective, name, monster);

    }

    public static void createSprintPlanningRoom () {

        Monster scopeCreep = new ScopeCreep(10, 50);
        sprintPlanningRoom = new SprintPlanning("Question", "Objective", "Sprint Planning Room", scopeCreep);

    }

    @Override
    public void introductionText(){

    }

    @Override
    public void roomTask() {

    }

    @Override
    public void roomCheckAnswer() {

    }

    @Override
    public void roomResult() {

    }

    @Override
    public void roomFeedback() {

    }

    @Override
    public void multipleChoiceQuestion() {

    }

    @Override
    public void openQuestion() {

    }

    @Override
    public void puzzle() {

    }



}
