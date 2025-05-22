package StrategyClasses;

import classes.IRoom;

public class MultipleChoiceQuestion implements IRoom {
    private String question;

    public MultipleChoiceQuestion(String question) {
        this.question = question;
    }

    public void question() {
        System.out.println(question);
        System.out.println("Type here the letter of the correct answer: ");
    }
}
