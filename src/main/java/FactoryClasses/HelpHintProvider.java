package FactoryClasses;

import Interface.HintProvider;
import classes.Room;

public class HelpHintProvider implements HintProvider {
        private final Room room;

        public HelpHintProvider(Room room) {
                this.room = room;
        }

        @Override
        public String getHint() {
                return room.getHelpHint();
        }
}