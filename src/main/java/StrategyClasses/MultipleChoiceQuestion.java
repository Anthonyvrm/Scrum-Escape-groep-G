package StrategyClasses;

import Interface.IRoom;

public class MultipleChoiceQuestion implements IRoom {
    private final String question;

    public MultipleChoiceQuestion(String question) {
        this.question = question;
    }

    // Display multiple choice question.
    public void question() {
        System.out.println(question);
        System.out.println("Type here the letter of the correct answer: ");
    }
}
