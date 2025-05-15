package classes;

public class DeurObserver implements Observer{
    private Room room;

    public DeurObserver(Room room) {
        this.room = room;
    }

    @Override
    public void update() {

        System.out.println("The door is open.");
    }
}
