package rooms;

import FactoryClasses.HintProviderFactory;
import classes.IRoom;
import classes.Monster; //Stagnator
import classes.Room;
import monster.Stagnator;

import java.util.Scanner;

public class SprintRetrospective extends Room implements IRoom {
    private final Scanner scanner = new Scanner(System.in);

    public SprintRetrospective(String name, Monster monster, boolean isCorrect) {
        super(name, monster, isCorrect);
    }

    @Override
    public String getHelpHint() {
        return "Maybe if you did a stand-up this morning, you'd know the answer?";
    }

    @Override
    public String getFunnyHint(){
        return "Without legs you cant stand up!";
    }

    @Override
    public void introductionText() {
        System.out.println("Welcome to the SprintRetrospective room!");
        System.out.println("In this room, you will reflect on how a Scrum Team can learn from their experiences.");
        System.out.println("Use your knowledge to identify what can be improved by the Scrum Team.");
    }

    @Override
    public void roomTask() {
        System.out.println("Scenario:");
        System.out.println("The Scrum Team showed the results of their work after several sprints,");
        System.out.println("but the stakeholders were not happy with the results.");
        question();
    }

    @Override
    public void roomCheckAnswer() {
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("B")) {
            isCorrect = true;
            notifyObservers(isCorrect);
        } else {
            isCorrect = false;
            askForHint(scanner);
            notifyObservers(isCorrect);
        }
    }

    @Override
    public void roomResult() {
        if (isCorrect) {
            System.out.println("Correct! You've shown the ability to reflect and improve.");
            System.out.println("Now go to the last room where you will face HELL!!!.");

        } else {
            System.out.println("Incorrect. A strange fog fills the room...");
            System.out.println("A Retrospective Monster appears!");

        }
    }

    @Override
    public void roomFeedback() {
        if (!isCorrect) {
            System.out.println("The correct answer was: B) Better communication with the stakeholders is essential.");
            System.out.println("The purpose of the scrum team is to get the results the stakeholders wish for, that is why there involvements is important.");
            System.out.println("In a Sprint Retrospective, the team should reflect on collaboration, tools, and processes.");
            System.out.println("This helps ensure that future sprints are more effective.");
        }
    }
}

    //@Override
    //public void question() {
        //System.out.println("Question:");
        //System.out.println("What can the Scrum Team learn from this experience?");
        //System.out.println("A) The team should work harder");
        //System.out.println("B) The team should regularly involve the stakeholders during Sprint Reviews.");
        //System.out.println("C) That stakeholders don’t understand the technical work anyway, so it’s fine to exclude them.");
        //System.out.println("D) That the Sprint Review is optional and can be skipped if the team is busy.");
        //System.out.println("Type the letter of your answer: ");
    //}
//}
