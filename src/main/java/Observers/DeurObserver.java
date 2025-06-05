package Observers;

import Interface.QuestionObserver;
import classes.Room;

public class DeurObserver implements QuestionObserver {
    private Room room;

    // Constructor DeurObserver.
    public DeurObserver(Room room) {
        this.room = room;
    }

    // Waits for notification from answer question.
    // If the answer is correct, the door opens, otherwise it stays closed.
    @Override
    public void update(boolean isCorrect) {
        if (isCorrect) {
            System.out.println("The door is open.");
        }
        else {
            System.out.println("The door is closed.");
        }
    }
}
