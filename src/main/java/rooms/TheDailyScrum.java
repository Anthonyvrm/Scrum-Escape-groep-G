package rooms;

import FactoryClasses.HintProviderFactory;
import StrategyClasses.MultipleChoiceQuestion;
import StrategyClasses.OpenQuestion;
import classes.IRoom;
import classes.Monster; //Slowness
import classes.Room;
import monster.Slowness;

import java.util.Scanner;

public class TheDailyScrum extends Room implements IRoom {
    private final Scanner scanner = new Scanner(System.in);

    public TheDailyScrum(String name, Monster monster, boolean isCorrect) {
        super(name, monster, isCorrect);
        setQuestionStrategy(new MultipleChoiceQuestion("What is the main purpose of TheDailyScrum?\n" +
                "A) To report to the Scrum Master.\n" +
                "B) To plan the next sprint.\n" +
                "C) To synchronize and create a plan for the next 24 hours.\n" +
                "D) To assign tasks to developers.\n"));
        setHintProvider(FactoryClasses.HintProviderFactory.createRandomHintProvider(this));
    }

    @Override
    public String getFunnyHint(){
        return "Funny hint Daily Scrum";
    }

    @Override
    public String getHelpHint() {
        return "Helphint DailyScrum";
    }


    @Override
    public void introductionText() {
        System.out.println("Welcome to the TheDailyScrum room!");
        interactWithObject();
    }

    @Override
    public void roomTask() {
        System.out.println("Scenario:");
        System.out.println("The Scrum Team gathers each morning to show their task progress to the Scrum Master.");
        question();
    }

    @Override
    public void roomCheckAnswer() {
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("C")) {
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
            System.out.println("Correct! You've great knowledge about the TheDailyScrum!");
        } else {
            System.out.println("Incorrect.");
            System.out.println("Slowness has appeared from the corners of the room...!");
        }
    }

    @Override
    public void roomFeedback() {
        if (!isCorrect) {
            System.out.println("The correct answer was: C) To synchronize and create a plan for the next 24 hours.");
            System.out.println("The Daily Scrum is an event at the start of the day for the Scrum Team to inspect progress toward the Sprint goal.");
            System.out.println("It helps the team when creating a plan for the next 24 hours and assigning tasks to the members.");
            System.out.println("It's not a status report for the Scrum Master, but a planning event for the team.");
        }
    }
}

    //@Override
    //public void question() {
        //System.out.println("Question:");
        //System.out.println("What is the main purpose of TheDailyScrum?");
        //System.out.println("A) To report to the Scrum Master.");
        //System.out.println("B) To plan the next sprint.");
        //System.out.println("C) To synchronize and create a plan for the next 24 hours.");
        //System.out.println("D) To assign tasks to developers.");
        //System.out.println("Type the letter of your answer: ");
    //}

//}
