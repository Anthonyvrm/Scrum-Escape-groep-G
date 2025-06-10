package Testing;

import FactoryClasses.HelpHintProvider;
import FactoryClasses.HintProviderFactory;
import classes.Room;

public class HelpHintProviderStub extends HelpHintProvider {

    Room room;

    // Constructor HelpHintProvider
    public HelpHintProviderStub(Room room) {
       super(room);
    }

    @Override
    public String getHint() {
        return room.getHelpHint();
    }
}






