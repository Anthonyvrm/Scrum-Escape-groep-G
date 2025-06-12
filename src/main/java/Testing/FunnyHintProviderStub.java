package Testing;

import FactoryClasses.FunnyHintProvider;
import classes.Room;
import rooms.SprintPlanning;

public class FunnyHintProviderStub extends FunnyHintProvider {

    public Room room;

    public FunnyHintProviderStub(Room room) {
        super(room);
        this.room = new SprintPlanning(null, false, null);
    }

    @Override
    public String getHint() {
        return room.getFunnyHint();
    }
}

    class FunnyHintProviderStubTest {
        public static void main(String[] args) {

            FunnyHintProviderStub stub = new FunnyHintProviderStub(new SprintPlanning(null, false, null));

            if (stub.getHint() != null) {
                System.out.println("Test passed! Hint is received!");
            } else {
                System.out.println("Test failed! Hint is not received");
            }
        }
    }



