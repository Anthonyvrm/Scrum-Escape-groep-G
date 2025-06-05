package Joker;

import Interface.IJoker;
import classes.Room;

import java.util.Scanner;

public class HintJoker extends Joker implements IJoker {
    // Use the Joker in a room to get a hint.
    @Override
    public void useJokerIn(Room room) {
        // Mark joker when used.
        markJokerAsUsed();
        // Ask room to provode a hint.
        room.askForHint(new Scanner(System.in));

    }

    @Override
    public void applyTo(Room room) {

        markJokerAsUsed();

        room.askForHint(new Scanner(System.in));

    }
}
