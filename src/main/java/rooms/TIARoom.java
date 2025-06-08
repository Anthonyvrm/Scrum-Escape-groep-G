package rooms;

import Commands.JokerCommand;
import Game.GameUI;
import InteractWithObject.InteractWithObject;
import Interface.IRoom;
import StrategyClasses.OpenQuestion;
import classes.*;

import java.util.Scanner;

public class TIARoom extends Room implements IRoom {
    // Constructor initializes the room TIARoom.
    public TIARoom(Monster monster, boolean isCorrect, Player player) {
        super("TIA Room", monster, isCorrect, player);
        setQuestionStrategy(new OpenQuestion("What does the 'T' in TIA stand for?"));
        setHintProvider(FactoryClasses.HintProviderFactory.createRandomHintProvider(this));
        this.bookinfo = new BookInfo("The book is called: Transparency In Action. Why would you even be transparant to your team?");
        this.weapon = new Weapon();
        this.reward = new RoomReward();
        initializeInteractableObjects();

    }

    // Return a helpful hint.
    @Override
    public String getHelpHint() {
        return "All the people in the SCRUM process are honest with each other\n";
    }

    // Return a funny hint.
    @Override
    public String getFunnyHint(){
        return "This hint is as clear as the sky.\n";
    }

    // Display introduction text to the player.
    @Override
    public void introductionText() {
        System.out.println("===== TIA Room =====");
        System.out.println();
        System.out.println("This is the final challenge you must face before you have succeeded this test of intelligence and wisdom.");
        System.out.println("You have walked through every chamber and must now show your full understanding of the SCRUM process.");
        System.out.println("Good luck!");
        System.out.println();
        interactWithObject();
    }

    // Describe scenario.
    @Override
    public void roomTask() {
        System.out.println();
        System.out.println("Answer the following question about TIA, :");
        System.out.println();
        JokerCommand jokerCommand = new JokerCommand(player, new GameUI());
        jokerCommand.execute();
        question();
    }

    // Check the player's answer.
    @Override
    public void roomCheckAnswer() {
        CheckAnswer checker = new CheckAnswer(new Scanner(System.in));
        this.isCorrect = checker.isAnswerCorrect("Transparency", this); //Het correcte antwoord wordt meegegeven
    }

    // Displays the result of the player's answer.
    @Override
    public void roomResult() {
        if (isCorrect) {
            System.out.println("You have completed the TIARoom challenge and the SCRUM game!");
        } else {
            System.out.println("You have failed!");
            //!Summon monster
            System.out.println("The BOSS monster has appeared in the TIARoom!!!");
        }
    }

    // Display feedback to the player if the answer is false.
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
}
