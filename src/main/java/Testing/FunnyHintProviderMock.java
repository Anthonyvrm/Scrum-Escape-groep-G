package Testing;

import Interface.HintProvider;
import classes.Room;
import rooms.SprintPlanning;

class FunnyHintProviderTest implements HintProvider {
    // HintProvider that returns a useful hint to the given room.
    public Room room;

    // Constructor HelpHintProvider
    public FunnyHintProviderTest(Room room) {
            this.room = room;
        }

    public FunnyHintProviderTest() {}

    @Override
        public String getHint() {
            return room.getHelpHint();
        }
    }

class FunnyHintService {

    private FunnyHintProviderTest provider;
    private Room room;

    public FunnyHintService(Room room, FunnyHintProviderTest provider) {
        this.provider = provider;
        this.room = room;
    }

    public String roepFunnyHintAan() {
        String hint = provider.getHint();
        System.out.println("Test: " + hint);
        return hint;
    }
}

class FunnyHintProviderMock extends FunnyHintProviderTest {

    boolean succesvol = false;
    String mockHint = "This is now a funny mock hint!";

    public FunnyHintProviderMock(Room room) {
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


    class FunnyHintTest {
        public static void main(String[] args) {

            Room room = new SprintPlanning(null, false, null);
            FunnyHintProviderMock mock = new FunnyHintProviderMock(room);
            FunnyHintService service = new FunnyHintService(room, mock);
            if(service.roepFunnyHintAan().equals("This is now a funny mock hint!")) {
                System.out.println("Test passed!");
            }
            else{
                System.out.println("Test failed!");
            }

                                
        }
    }





