package FactoryClasses;

import Interface.HintProvider;
import classes.Room;

public class FunnyHintProvider implements HintProvider {
    private final Room room;

    public FunnyHintProvider(Room room) {
        this.room = room;
    }

    @Override
    public String getHint() {
        return room.getFunnyHint();
    }
}