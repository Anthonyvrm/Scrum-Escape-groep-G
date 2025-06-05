package StrategyClasses;

import Interface.IRoom;

public class Puzzle implements IRoom {
    private final String question;

    public Puzzle(String question) {
        this.question = question;
    }

    // Display puzzle question.
    public void question() {
        System.out.println(question);
        System.out.print("Type your answer: ");
    }
}
