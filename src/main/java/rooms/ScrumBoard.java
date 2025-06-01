package rooms;

import Interface.IRoom;
import StrategyClasses.OpenQuestion;
import classes.*;

import java.util.Scanner;

public class ScrumBoard extends Room implements IRoom {
    public ScrumBoard(Monster monster, boolean isCorrect) {
        super("Scrumboard Room", monster, isCorrect);
        setQuestionStrategy(new OpenQuestion("In order to tell the people what to do this day, what is the name of the first thing you should do with this team?\n"));
        setHintProvider(FactoryClasses.HintProviderFactory.createRandomHintProvider(this));
        this.bookinfo = new BookInfo("Title : Trello for dummies.. Urgh what a horrible book, who even wants a project with clear structure?");
        this.weapon = new Weapon();
        this.reward = new RoomReward();
        this.interactableObjects = new InteractWithObject(bookinfo, weapon, reward);

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
        System.out.println("You are in the Scrum Board room! You can see many people talking about the project.");
        interactWithObject();
    }

    @Override
    public void roomTask() {
        System.out.println("Scenario: ");
        System.out.println("You have been transformed to a Scrum Master.");
        System.out.println("All the people are looking at the board, they are clueless as to what they need to do next.");
        question();
    }

    @Override
    public void roomCheckAnswer() {
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine().trim();

        if (answer.equalsIgnoreCase("Daily Stand Up")) {
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
            System.out.println(" ");
            System.out.println("Correct! With a daily stand up you can see how everyone is doing, and talk about what they need to do next.");
        } else {
            System.out.println(" ");
            System.out.println("Incorrect. A strange fog fills the room...");
            System.out.println("Trollo appears!");
        }
    }

    @Override
    public void roomFeedback() {
        if (!isCorrect) {
            System.out.println("The correct answer was: Daily Stand Up.");
            System.out.println("In Scrum, a daily stand up is a short, informal meeting where the team members share their progress and problems.");
            System.out.println("This helps the team to stay on track and keep the project on track.");
        }
    }
}
