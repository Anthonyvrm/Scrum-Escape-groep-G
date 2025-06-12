package rooms;

import Commands.JokerCommand;
import Game.GameUI;
import InteractWithObject.InteractWithObject;
import Interface.IRoom;
import StrategyClasses.OpenQuestion;
import classes.*;

import java.util.Scanner;

public class ScrumBoard extends Room implements IRoom {
    // Constructor initializes the room ScrumBoard.
    public ScrumBoard(Monster monster, boolean isCorrect, Player player) {
        super("Scrumboard Room", monster, isCorrect, player);
        // Set the question type of the room and the text.
        setQuestionStrategy(new OpenQuestion("In order to tell the people what to do this day, what is the name of the first thing you should do with this team?\n"));
        setHintProvider(FactoryClasses.HintProviderFactory.createRandomHintProvider(this));
        this.bookinfo = new BookInfo("Title : Trello for dummies.. Urgh what a horrible book, who even wants a project with clear structure?");
        this.weapon = new Weapon();
        this.reward = new RoomReward();
        initializeInteractableObjects();
    }

    // Return a helpful hint.
    @Override
    public String getHelpHint() {
        return "Maybe if you did a stand-up this morning, you'd know the answer?\n";
    }

    // Return a funny hint.
    @Override
    public String getFunnyHint(){
        return "Without legs you cant stand up!\n";
    }

    // Display introduction text to the player.
    @Override
    public void introductionText() {
        System.out.println("===== ScrumBoard Room =====");
        System.out.println();
        interactWithObject();
    }

    // Describe scenario.
    @Override
    public void roomTask() {
        System.out.println();
        System.out.println("Scenario: ");
        System.out.println("You have been transformed to a Scrum Master.");
        System.out.println("All the people are looking at the board, they are clueless as to what they need to do next.");
        System.out.println();
        JokerCommand jokerCommand = new JokerCommand(player, new GameUI());
        jokerCommand.execute();
        question();
        }


    // Check the player's answer.
    @Override
    public void roomCheckAnswer() {
        CheckAnswer checker = new CheckAnswer(new Scanner(System.in));
        this.isCorrect = checker.isAnswerCorrect("Daily Stand Up", this);
    }


    // Displays the result of the player's answer.
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

    // Display feedback to the player if the answer is false.
    @Override
    public void roomFeedback() {
        if (!isCorrect) {
            System.out.println("The correct answer was: Daily Stand Up.");
            System.out.println("In Scrum, a daily stand up is a short, informal meeting where the team members share their progress and problems.");
            System.out.println("This helps the team to stay on track and keep the project on track.");
        }
    }
}