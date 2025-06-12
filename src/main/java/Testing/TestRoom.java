package Testing;

import classes.Monster;
import classes.Player;
import classes.Room;

public class TestRoom extends Room {
    //public boolean isCorrect = false;
    public TestRoom(String name, Monster monster, boolean isCorrect, Player player) {
        super(name, monster, isCorrect, player);
    }

    @Override
    public String getFunnyHint() {
        return "Test funny hint";
    }

    @Override
    public String getHelpHint() {
        return "Test help hint";
    }

    @Override
    public void introductionText() {
        System.out.println("Test room introduction text");
    }

    @Override
    public void roomTask() {
        System.out.println("Test room task");
    }

    @Override
    public void roomCheckAnswer() {
        System.out.println("Test room check answer");
    }

    @Override
    public void roomResult() {
        System.out.println("Test room result");
    }

    @Override
    public void roomFeedback() {
        System.out.println("Test room feedback");
    }
}
