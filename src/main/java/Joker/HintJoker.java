package Joker;

import Interface.IJoker;
import classes.Room;

import java.util.Scanner;

public class HintJoker extends Joker implements IJoker {
    @Override
    public void useJokerIn(Room room) {
        markJokerAsUsed();
        room.askForHint(new Scanner(System.in));
    }

    @Override
    public void applyTo(Room room) {
        markJokerAsUsed();
        room.askForHint(new Scanner(System.in));
    }
}
