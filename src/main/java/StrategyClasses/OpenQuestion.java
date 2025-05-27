package StrategyClasses;

import Interface.IRoom;

public class OpenQuestion implements IRoom {
    private final String question;

    public OpenQuestion(String question) {
        this.question = question;
    }

    public void question () {
        System.out.println(question);
        System.out.print("Type your answer: ");
    }
}
