package Joker;

import classes.Room;

public abstract class Joker {
    private boolean used;

    // Constructor initializes Joker.
    public Joker() {
        this.used = false;
    }

    // If the joker has been used throw exception, otherwise mark it.
    public void markJokerAsUsed() {
        if (used) {
            throw new IllegalStateException("Joker is already used!");
        } else {
            used = true;
        }
    }

    // Method to use the joker in the current Room.
    public void useJokerIn(Room room) {
        room.applyKeyJoker(this);
    }


}
