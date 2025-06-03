package Joker;

import Game.Game;
import Interface.IJoker;
import Interface.KeyableRoom;
import classes.Room;
import classes.RoomNavigator;

public class KeyJoker extends Joker {
    @Override
    public void useJokerIn(Room room) {
        room.applyKeyJoker(this);
    }
}



