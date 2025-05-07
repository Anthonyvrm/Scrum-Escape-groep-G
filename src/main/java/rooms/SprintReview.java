package rooms;

import classes.Monster; //Monster Feedback phantom. This ghost appears when feedback from stakeholders is not taken seriously or is misinterpreted. It whispers false conclusions and causes the team to go in the wrong direction.
import classes.Room;

public class SprintReview extends Room {
    public SprintReview(String question, String objective, String name, Monster monster){
        super(question, objective, name, monster);
    }
}
