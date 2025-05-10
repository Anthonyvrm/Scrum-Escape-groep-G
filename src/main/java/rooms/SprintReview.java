package rooms;

import classes.IRoom;
import classes.Monster; //Feedback Phantom
import classes.Room;

public class SprintReview extends Room implements IRoom {
    public SprintReview(String question, String objective, String name, Monster monster){
        super(question, objective, name, monster);
    }

    @Override
    public void introductionText() {

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
