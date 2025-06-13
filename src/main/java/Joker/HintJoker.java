package Joker;

import Interface.IJoker;
import classes.Room;

import java.util.Scanner;

public class HintJoker extends Joker implements IJoker {
    // Use the Joker in a room to get a hint.
    @Override
    protected void performJokerAction(Room room) {
        room.askForHint(new Scanner(System.in));
    }



    public void applyTo(Room room) {
        useJokerIn(room);
    }
}
