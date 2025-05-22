package rooms;

import classes.IRoom;

import java.util.Scanner;

public class TheDailyScrum implements IRoom {
    @Override
    public void introductionText() {
        System.out.println("Welcome to the TheDailyScrum room!");
    }

    @Override
    public void roomTask() {
        System.out.println("Scenario:");
        System.out.println("The Scrum Team gathers each morning to show their task progress to the Scrum Master.");
        question();
    }

    @Override
    public boolean roomCheckAnswer(Scanner scanner) {
        String answer = scanner.nextLine();
        return answer.equalsIgnoreCase("C");
    }

    @Override
    public void roomResult(boolean isCorrect) {
        if (isCorrect) {
            System.out.println("Correct! You've great knowledge about the TheDailyScrum!");
        } else {
            System.out.println("Incorrect.");
            System.out.println("Slowness has appeared from the corners of the room...!");
        }
    }

    @Override
    public void roomFeedback(boolean isCorrect) {
        if (!isCorrect) {
            System.out.println("The correct answer was: C) To synchronize and create a plan for the next 24 hours.");
            System.out.println("The Daily Scrum is an event at the start of the day for the Scrum Team to inspect progress toward the Sprint goal.");
            System.out.println("It helps the team when creating a plan for the next 24 hours and assigning tasks to the members.");
            System.out.println("It's not a status report for the Scrum Master, but a planning event for the team.");
        }
    }

    @Override
    public void question() {
        System.out.println("Question:");
        System.out.println("What is the main purpose of TheDailyScrum?");
        System.out.println("A) To report to the Scrum Master.");
        System.out.println("B) To plan the next sprint.");
        System.out.println("C) To synchronize and create a plan for the next 24 hours.");
        System.out.println("D) To assign tasks to developers.");
        System.out.println("Type the letter of your answer: ");
    }
}
