package classes;

public class DeurObserver implements QuestionObserver {
    private Room room;

    public DeurObserver(Room room) {
        this.room = room;
    }

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
