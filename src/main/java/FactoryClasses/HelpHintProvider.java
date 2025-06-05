package FactoryClasses;

import Interface.HintProvider;
import classes.Room;

// HintProvider that returns a useful hint to the given room.
public class HelpHintProvider implements HintProvider {
        private final Room room;

        // Constructor HelpHintProvider
        public HelpHintProvider(Room room) {
                this.room = room;
        }

        @Override
        public String getHint() {
                return room.getHelpHint();
        }
}