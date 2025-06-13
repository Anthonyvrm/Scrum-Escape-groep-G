package Joker;

import classes.Room;

public abstract class Joker {
    private boolean used;

    // Constructor initializes Joker.
    public Joker() {
        this.used = false;
    }

    public boolean isUsed() {
        return used;
    }

    // If the joker has been used throw exception, otherwise mark it.
    public void markJokerAsUsed() {


    }

    protected abstract void performJokerAction(Room room);
    // Method to use the joker in the current Room.
    public void useJokerIn(Room room) {
        if (used) {
            System.out.println("This joker has already been used.");
            return;

            //throw new IllegalStateException("Joker has already been used.");
        } else {
            used = true;
            System.out.println("Joker has been marked as used!");
            System.out.println();
            performJokerAction(room);
        }
    }
}


