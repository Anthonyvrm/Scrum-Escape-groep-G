package rooms;

import classes.IRoom;
import classes.Monster; //The Scrum Reaper
import classes.Room;

public class TIARoom extends Room implements IRoom {

    public TIARoom (String question, String object, String name, Monster monster) {
        super(question, object, name, monster);
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
