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

    public boolean getUsed() {
        return used;
    }

    // If the joker has been used throw exception, otherwise mark it.
    public void markJokerAsUsed() {

        if (used) {
            System.out.println("This joker has already been used.");
            //throw new IllegalStateException("Joker has already been used.");
        } else {
            used = true;
            System.out.println("Joker has been marked as used!");
            System.out.println();
        }
    }

    // Method to use the joker in the current Room.
    public void useJokerIn(Room room) {
        room.applyKeyJoker(this);
    }
}


