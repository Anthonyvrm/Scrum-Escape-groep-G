package StrategyClasses;

import classes.IRoom;

public class Puzzle implements IRoom {
    private final String question;

    public Puzzle(String question) {
        this.question = question;
    }

    public void question() {
        System.out.println(question);
        System.out.print("Type your answer: ");
    }
}
