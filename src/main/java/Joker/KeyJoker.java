package Joker;

import Interface.IJoker;
import Interface.KeyableRoom;
import classes.Room;

public class KeyJoker extends Joker {
    @Override
    public void useJokerIn(Room room) {
        if (!(room instanceof KeyableRoom)) {
            return;
    }

        markJokerAsUsed();
        ((KeyableRoom) room).addKey();
    }
}



