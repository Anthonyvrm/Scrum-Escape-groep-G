package Joker;

import Game.Game;
import Interface.IJoker;
import Interface.KeyableRoom;
import classes.Room;
import classes.RoomNavigator;

public class KeyJoker extends Joker {
    @Override
    public void useJokerIn(Room room) {
        if (!(room instanceof KeyableRoom)) {
            System.out.println("This room is not keyable!");


    }
        else {

            markJokerAsUsed();
            ((KeyableRoom) room).addKey();
        }


    }
}



