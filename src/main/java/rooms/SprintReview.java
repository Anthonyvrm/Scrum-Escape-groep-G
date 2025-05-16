package rooms;

import classes.IRoom;
import classes.Monster; //Feedback Phantom
import classes.Room;
import monster.FeedbackPhantom;

import java.util.Scanner;

public class SprintReview extends Room implements IRoom {
    private final Scanner scanner = new Scanner(System.in);
    public SprintReview(String name, Monster monster, boolean isCorrect){
        super(name, monster, isCorrect);
    }

    @Override
    public void introductionText() {
        System.out.println ("Welcome to the SprintReview room!");
    }

    @Override
    public void roomTask() {
        System.out.println ("In this room you will display your knowledge, about the subject in SCRUM: the Sprint Review!");
    }

    @Override
    public void roomCheckAnswer() {
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("C")) {
            isCorrect = true;
            notifyObservers(isCorrect);
        } else {
            isCorrect = false;
            notifyObservers(isCorrect);
        }
    }

    @Override
    public void roomResult() {
        if (isCorrect) {
            System.out.println("Correct! You've displayed your knowledge about the Sprint Review!");
            System.out.println("A portal appears to have spawned in the Sprint Review room...!");
        } else {
            System.out.println("Incorrect. The walls start ttttremblinggg...");
            System.out.println("The Feedback Phantom has appeared from the shadows of the room...!");
        }
    }

    @Override
    public void roomFeedback() {
        if (!isCorrect) {
            System.out.println("The correct answer was: C) To all the stakeholders.");
            System.out.println("During the Sprint Review, the Scrum Team presents the work that was completed during the sprint.");
            System.out.println("This meeting includes not only the team and the Product Owner, but also external stakeholders.");
            System.out.println("This is an important opportunity for the Scrum Team to get feedback from the stakeholders and Product Owner,");
            System.out.println("on how to proceed with the project.");
        }
    }

    @Override
    public void multipleChoiceQuestion() {
        System.out.println("Question:");
        System.out.println("To whom does the Scrum Team show their results during the Sprint Review?");
        System.out.println("A) To the Scrum Master.");
        System.out.println("B) Only to the Product Owner.");
        System.out.println("C) To all the stakeholders.");
        System.out.println("D) They dont show it to anybody outside the Scrum Team.");
        System.out.println("Type the letter of your answer: ");
    }

    @Override
    public void openQuestion() {

    }

    @Override
    public void puzzle() {

    }
}
