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

public class SprintReview extends Room implements IRoom, KeyableRoom {
    // Constructor initializes the room SprintReview.
    public SprintReview(Monster monster, boolean isCorrect, Player player) {
        super("Sprint Review Room", monster, isCorrect, player);
        setQuestionStrategy(new MultipleChoiceQuestion("To whom does the Scrum Team show their results during the Sprint Review?\n" +
                "A) To the Scrum Master.\n" +
                "B) Only to the Product Owner.\n" +
                "C) To all the stakeholders.\n" +
                "D) They dont show it to anybody outside the Scrum Team.\n"));
        setHintProvider(FactoryClasses.HintProviderFactory.createRandomHintProvider(this));
        this.bookinfo = new BookInfo("The book is called: Sprint Review. Why would you even review the sprint?");
        this.weapon = new Weapon();
        this.reward = new RoomReward();
        initializeInteractableObjects();

    }

    // If the player uses a key, the player will be able to move to the next room.
    @Override
   public void addKey(boolean used, Joker joker) {
        // Set answer to correct, so the player can move to the next room.
        if (used) {
            System.out.println("You used the key!");
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


    // Return a helpful hint.
    @Override
    public String getHelpHint() {
        return "maybe letting the most important people in this project show what you are up to is a good idea?";
    }

    // Return a funny hint.
    @Override
    public String getFunnyHint(){
        return "You should quickly show what you are doing before they use chatgpt instead of paying you ";
    }

    // Display introduction text to the player.
    @Override
    public void introductionText() {
        System.out.println("===== SprintReview room =====");
        interactWithObject();
    }

    // Describe scenario.
    @Override
    public void roomTask() {
        System.out.println("In this room you will display your knowledge, about the subject in SCRUM: the Sprint Review!");
        JokerCommand jokerCommand = new JokerCommand(player, new GameUI());
        jokerCommand.execute();
        if (this.isCorrect) {
            return;
        }
        question();
    }

    // Check the player's answer.t=
    @Override
    public void roomCheckAnswer() {
        CheckAnswer checker = new CheckAnswer(new Scanner(System.in));
        this.isCorrect = checker.isAnswerCorrect("C", this);
    }

    // Displays the result of the player's answer.
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

    // Display feedback to the player if the answer is false.
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
}
