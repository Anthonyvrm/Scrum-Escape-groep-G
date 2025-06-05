package Joker;

import Game.Game;
import Interface.IJoker;
import Interface.KeyableRoom;
import classes.Room;
import classes.RoomNavigator;

public class KeyJoker extends Joker {
    // Overrides the useJokerIn method to apply the KeyJoker effect on the current room.
    @Override
    public void useJokerIn(Room room) {

        room.applyKeyJoker(this);

    }
}



