package rooms;

import classes.Monster;
import classes.Room;

public class ScrumBoard extends Room {

    public ScrumBoard (String question, String objective, String name, Monster monster ) {
        super(question, objective, name, monster);


    }
    public ScrumBoard(String question, String objective, String name) {
        super(question, objective, name);
    }

}
