package rooms;

import classes.Monster; //Monster Feedback phantom. This ghost appears when feedback from stakeholders is not taken seriously or is misinterpreted. It whispers false conclusions and causes the team to go in the wrong direction.
import classes.Room;
import monster.ScopeCreep;

public class SprintReview extends Room {
    public static Room sprintReviewRoom;
    public SprintReview(String question, String objective, String name, Monster monster){
        super(question, objective, name, monster);
    }

    public static void createRoom(){
        Monster scopeCreep = new ScopeCreep(10, 50);
        sprintReviewRoom = new SprintReview("Question", "Objective", "Sprint Planning Room", scopeCreep);
    }
}
