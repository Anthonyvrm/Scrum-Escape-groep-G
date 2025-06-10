package Testing;

import FactoryClasses.HelpHintProvider;
import FactoryClasses.HintProviderFactory;
import classes.Room;
import rooms.SprintPlanning;

public class HelpHintProviderStub extends HelpHintProvider {

    public Room room;

    // Constructor HelpHintProvider
    public HelpHintProviderStub(Room room) {
        super(room);
        this.room = new SprintPlanning(null,false,null,null);
    }

    @Override
    public String getHint() {
        return room.getHelpHint();
    }
}






