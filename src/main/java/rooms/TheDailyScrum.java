package rooms;

import classes.IRoom;
import classes.Monster; //Slowness
import classes.Room;
import monster.Slowness;

public class TheDailyScrum extends Room implements IRoom {
    public TheDailyScrum(String question, String objective, String name, Monster monster, boolean isCorrect) {
        super(question, objective, name, monster, isCorrect);
    }

    public static void createTheDailyScrumRoom() {
        Monster slowness = new Slowness(10, 50);
        Room theDailyScrum = new TheDailyScrum("Question", "Objective", "Name", slowness, true);
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
