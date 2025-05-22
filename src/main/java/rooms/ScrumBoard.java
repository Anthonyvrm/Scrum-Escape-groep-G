package rooms;

import classes.IRoom;

import java.util.Scanner;

public class ScrumBoard  implements IRoom {
    @Override
    public void introductionText() {
        System.out.println("You are in the Scrum Board room! You can see many people talking about the project.");
    }

    @Override
    public void roomTask() {
        System.out.println("Scenario: ");
        System.out.println("You have been transformed to a Scrum Master.");
        System.out.println("All the people are looking at the board, they are clueless as to what they need to do next.");
        question();
    }

    @Override
    public boolean roomCheckAnswer(Scanner scanner) {
        String answer = scanner.nextLine();
        return answer.equalsIgnoreCase("Daily Stand Up");
    }

    @Override
    public void roomResult(boolean isCorrect) {
        if (isCorrect) {
            System.out.println(" ");
            System.out.println("Correct! With a daily stand up you can see how everyone is doing, and talk about what they need to do next.");
        } else {
            System.out.println(" ");
            System.out.println("Incorrect. A strange fog fills the room...");
            System.out.println("Trollo appears!");
        }
    }

    @Override
    public void roomFeedback(boolean isCorrect) {
        if (!isCorrect) {
            System.out.println("The correct answer was: Daily Stand Up.");
            System.out.println("In Scrum, a daily stand up is a short, informal meeting where the team members share their progress and problems.");
            System.out.println("This helps the team to stay on track and keep the project on track.");
        }
    }

    @Override
    public void question() {
        System.out.println("In order to tell the people what to do this day, what is the name of the first thing you should do with this team?");
        System.out.println("Type your answer: ");
    }
}
