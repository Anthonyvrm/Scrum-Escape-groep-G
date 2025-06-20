package Joker;

import Game.Game;
import Interface.IJoker;
import Interface.KeyableRoom;
import classes.Room;
import classes.RoomNavigator;

public class KeyJoker extends Joker {
    @Override
    public void performJokerAction(Room room) {
        // Do nothing.
    }
    // Overrides the useJokerIn method to apply the KeyJoker effect on the current room.
    @Override
    public void useJokerIn(Room room) {

        room.applyKeyJoker(this);

        //if (room.wasUnlockedByKey()) {
            //room.setIsCorrect(true);
            //room.notifyObservers(true);
           //Game.getGameEngine().getRoomNavigator().goToNextRoom();
        }
    }




