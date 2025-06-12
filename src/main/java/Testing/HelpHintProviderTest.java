package Testing;

import FactoryClasses.HelpHintProvider;
import Interface.HintProvider;
import classes.Room;
import rooms.SprintPlanning;

public class HelpHintProviderTest implements HintProvider {
    // HintProvider that returns a useful hint to the given room.
    public Room room;

    // Constructor HelpHintProvider
    public HelpHintProviderTest(Room room) {
            this.room = room;
        }

    @Override
        public String getHint() {
            return room.getHelpHint();
        }
    }

class HelpHintService {

    private HelpHintProviderTest provider;
    private Room room;

    public HelpHintService(Room room, HelpHintProviderTest provider) {
        this.provider = provider;
        this.room = room;
    }

    public String roepHelpHintAan() {
        String hint = provider.getHint();
        System.out.println("Test: " + hint);
        return hint;
    }
}

class HelpHintProviderMock extends HelpHintProviderTest {

    boolean succesvol = false;
    String mockHint = "This is now a mock hint!";

    public HelpHintProviderMock(Room room) {
        super(room);
    }

    @Override
    public String getHint() {
        succesvol = true;

        System.out.println("Test: " + room.getHelpHint());
        System.out.println(succesvol);
        return mockHint;

    }
}

class Test {
    public static void main(String[] args) {
        Room room = new SprintPlanning(null, false, null);
        HelpHintProviderMock mock = new HelpHintProviderMock(room);
        HelpHintService service = new HelpHintService(room, mock);
        if(service.roepHelpHintAan().equals("This is now a mock hint!")){
            System.out.println("Test passed!");
        } else {
            System.out.println("Test failed!");
        }
    }
}





