package Joker;

import classes.Room;

import java.lang.classfile.instruction.ExceptionCatch;
import java.lang.reflect.UndeclaredThrowableException;

public abstract class Joker {
    private boolean used;

    // Constructor initializes Joker.
    public Joker() {
        this.used = false;
    }

    // If the joker has been used throw exception, otherwise mark it.
    public void markJokerAsUsed() {

        if (used) {
            throw new IllegalStateException("Joker has already been used.");
        } else {
            used = true;
        }
    }

    // Method to use the joker in the current Room.
    public void useJokerIn(Room room) {
        room.applyKeyJoker(this);
    }
}
