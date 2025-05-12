package rooms;

import classes.IRoom;
import classes.Monster; //The Scrum Reaper
import classes.Room;

import java.util.Scanner;

public class TIARoom extends Room implements IRoom {
    private final Scanner scanner = new Scanner(System.in);
    private boolean isCorrect;

    public TIARoom (String question, String object, String name, Monster monster, boolean isCorrect) {
        super(question, object, name, monster, isCorrect);
    }

    @Override
    public void introductionText() {
        System.out.println ("Welcome to the TIARoom!");
        System.out.println ("This is the final challenge you must face before you have succeeded this test of intelligence and wisdom.");
        System.out.println ("You have walked through every chamber and must now show your full understanding of the SCRUM process.");
        System.out.println ("Good luck!");
    }

    @Override
    public void roomTask() {
        System.out.println ("Answer the following question.");
        System.out.println ("What does the 'T' in TIA stand for?");
        System.out.println ("Type your answer:");
    }

    @Override
    public void roomCheckAnswer() {
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("Transparency")) {
            isCorrect = true;
        }
        else {
            isCorrect = false;
            //System.out.println ("Wrong answer, the 'T' in TIA stands for 'Transparency'.");
        }
    }

    @Override
    public void roomResult() {
        if (isCorrect) {
            System.out.println ("You have completed the TIARoom challenge and the SCRUM game!");
        }
        else {
            System.out.println ("You have failed!");
            // Summon monster
            System.out.println ("The BOSS monster has appeared in the TIARoom!!!");
        }
    }
    @Override
    public void roomFeedback() {
        if (!isCorrect) {
            System.out.println("The correct answer was: Transparency.");
            System.out.println("In Scrum, Transparency is one of the three pillars.");
            System.out.println("Transparency means that all people involved in the SCRUM process are transparent with each other.");
            System.out.println("They all trust each other, and give each other the good news as well as the bad news.");
            System.out.println("Everyone collaborates for the common purpose that they have decided to achieve");
        }
    }
    @Override
    public void multipleChoiceQuestion() {

    }

    @Override
    public void openQuestion() {

    }

    @Override
    public void puzzle() {
    }
}
