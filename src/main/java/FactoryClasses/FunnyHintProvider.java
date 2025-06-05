package FactoryClasses;

import Interface.HintProvider;
import classes.Room;

// HintProvider that returns a funny hint to the given room.
public class FunnyHintProvider implements HintProvider {
    private final Room room;

    // Constructor FunnyHintProvider
    public FunnyHintProvider(Room room) {
        this.room = room;
    }

    @Override
    public String getHint() {
        return room.getFunnyHint();
    }
}