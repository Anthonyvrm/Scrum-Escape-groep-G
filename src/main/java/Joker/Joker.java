package Joker;

import classes.Room;

public abstract class Joker {
    private boolean used;

    public Joker() {
        this.used = false;
    }

    public void markJokerAsUsed() {
        if (used) {
            throw new IllegalStateException("Joker is already used!");
        } else {
            used = true;
        }
    }

    public abstract void useJokerIn(Room room);

}
