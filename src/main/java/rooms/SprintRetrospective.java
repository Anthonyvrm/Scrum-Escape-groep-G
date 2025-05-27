package rooms;

import Interface.IRoom;
import StrategyClasses.MultipleChoiceQuestion;
import classes.*;

import java.util.Scanner;

public class SprintRetrospective extends Room implements IRoom {
    public SprintRetrospective(Monster monster, boolean isCorrect) {
        super("Sprint Retrospective Room", monster, isCorrect);
        setQuestionStrategy(new MultipleChoiceQuestion("What can the Scrum Team learn from this experience?\n" +
                "A) The team should work harder\n" +
                "B) The team should regularly involve the stakeholders during Sprint Reviews.\n" +
                "C) That stakeholders don’t understand the technical work anyway, so it’s fine to exclude them.\n" +
                "D) That the Sprint Review is optional and can be skipped if the team is busy.\n"));
        setHintProvider(FactoryClasses.HintProviderFactory.createRandomHintProvider(this));
        this.bookinfo = new BookInfo("The book is titled: Retrospective. Why would you reflect even reflect on your behaviour within the team?");
        this.weapon = new Weapon();
    }

    @Override
    public String getHelpHint() {
        return "include the important group of people deciding your project for some feedback here and there";
    }

    @Override
    public String getFunnyHint(){
        return "Quick tip you should probably include the people who decide your paycheck";
    }

    @Override
    public void introductionText() {
        System.out.println("Welcome to the SprintRetrospective room!");
        System.out.println("In this room, you will reflect on how a Scrum Team can learn from their experiences.");
        System.out.println("Use your knowledge to identify what can be improved by the Scrum Team.");
        interactWithObject();
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
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine().trim();

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