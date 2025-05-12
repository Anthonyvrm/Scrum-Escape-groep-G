package rooms;

import classes.IRoom;
import classes.Monster; //Slowness
import classes.Room;

public class TheDailyScrum extends Room implements IRoom {
    public TheDailyScrum(String question, String objective, String name, Monster monster, boolean isCorrect) {
        super(question, objective, name, monster, isCorrect);
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
