package rooms;

import Commands.JokerCommand;
import Commands.NextRoomCommand;
import Game.Game;
import Game.GameUI;
import InteractWithObject.InteractWithObject;
import Interface.IRoom;
import Interface.KeyableRoom;
import Joker.Joker;
import StrategyClasses.MultipleChoiceQuestion;
import classes.*;

import java.util.Scanner;

public class TheDailyScrum extends Room implements IRoom, KeyableRoom {
    private final Scanner scanner = new Scanner(System.in);

    // Constructor initializes the room TheDailyScrum.
    public TheDailyScrum(Monster monster, boolean isCorrect, Player player) {
        super("The Daily Scrum Room", monster, isCorrect, player);
        setQuestionStrategy(new MultipleChoiceQuestion("What is the main purpose of TheDailyScrum?\n" +
                "A) To report to the Scrum Master.\n" +
                "B) To plan the next sprint.\n" +
                "C) To synchronize and create a plan for the next 24 hours.\n" +
                "D) To assign tasks to developers.\n"));
        setHintProvider(FactoryClasses.HintProviderFactory.createRandomHintProvider(this));
        this.bookinfo = new BookInfo("The book is called: Daily Scrum for dummies. Are daily stand ups useless or are they actually useful?");
        this.weapon = new Weapon();
        this.reward = new RoomReward();
        initializeInteractableObjects();

    }

    // If the player uses a key, the player will be able to move to the next room.
    @Override
    public void addKey(boolean used, Joker joker) {
        // Set answer to correct, so the player can move to the next room.
        // 1) Markeer deze kamer als “klaar” (optioneel, voor observables)
        if (used) {
            System.out.println("You used the joker already!");
        }
        else {
            joker.markJokerAsUsed();
            setIsCorrect(true);
            notifyObservers(true);
            RoomNavigator navigator = Game.getGameEngine().getRoomNavigator();
            navigator.goToNextRoom();

        }
    }

    // Apply Joker ability (key), the question gets automatically answered.
    @Override
    public void applyKeyJoker(Joker joker) {
        addKey(joker.getUsed(), joker);
    }

    // Return a funny hint.
    @Override
    public String getFunnyHint(){
        return "You have no friends so work the entire day.";
    }

    // Return a helpful hint.
    @Override
    public String getHelpHint() {
        return "Creating structure when working together is essential for a successful Scrum Team.";
    }

    // Display introduction text to the player.
    @Override
    public void introductionText() {
        System.out.println("====== TheDailyScrum room =====");
        interactWithObject();
    }

    // Describe scenario.
    @Override
    public void roomTask() {
        System.out.println("Scenario:");
        System.out.println("The Scrum Team gathers each morning to show their task progress to the Scrum Master.");
        JokerCommand jokerCommand = new JokerCommand(player, new GameUI());
        jokerCommand.execute();
        if (this.isCorrect) {
            System.out.println("THIS IS CORRECT");
            return;
        }

        question();
    }

    // Check the player's answer.
    @Override
    public void roomCheckAnswer() {

        System.out.println("Answer is getting checked..");
        CheckAnswer checker = new CheckAnswer(new Scanner(System.in));
        this.isCorrect = checker.isAnswerCorrect("C", this);

        if (this.isCorrect) {
            System.out.println("Answer has been checked and is correct.");
        }
    }

    // Displays the result of the player's answer.
    @Override
    public void roomResult() {
        if (isCorrect) {
            System.out.println("Correct! You've great knowledge about the TheDailyScrum!");
        } else {
            System.out.println("Incorrect.");
            System.out.println("Slowness has appeared from the corners of the room...!");
        }
    }

    // Display feedback to the player if the answer is false.
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
