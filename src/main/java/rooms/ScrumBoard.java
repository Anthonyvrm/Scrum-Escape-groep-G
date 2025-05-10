package rooms;

import classes.Monster; //Trollo
import classes.Room;

public class ScrumBoard extends Room {

    public ScrumBoard (String question, String objective, String name, Monster monster ) {
        super(question, objective, name, monster);


    }

    public ScrumBoard(String question, String objective, String name) {

        super(question, objective, name);
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

}
