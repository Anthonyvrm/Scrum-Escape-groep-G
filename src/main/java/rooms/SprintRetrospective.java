package rooms;

import Commands.JokerCommand;
import Game.GameUI;
import InteractWithObject.InteractWithObject;
import Interface.IRoom;
import StrategyClasses.MultipleChoiceQuestion;
import classes.*;

import java.util.Scanner;

public class SprintRetrospective extends Room implements IRoom {
    // Constructor initializes the room SprintRetrospective.
    public SprintRetrospective(Monster monster, boolean isCorrect, Player player) {
        super("Sprint Retrospective Room", monster, isCorrect, player);
        setQuestionStrategy(new MultipleChoiceQuestion("What can the Scrum Team learn from this experience?\n" +
                "A) The team should work harder\n" +
                "B) The team should regularly involve the stakeholders during Sprint Reviews.\n" +
                "C) That stakeholders don’t understand the technical work anyway, so it’s fine to exclude them.\n" +
                "D) That the Sprint Review is optional and can be skipped if the team is busy.\n"));
        setHintProvider(FactoryClasses.HintProviderFactory.createRandomHintProvider(this));
        this.bookinfo = new BookInfo("The book is titled: Retrospective. Why would you reflect even reflect on your behaviour within the team?");
        this.weapon = new Weapon();
        this.reward = new RoomReward();
        initializeInteractableObjects();


    }

    // Return a helpful hint.
    @Override
    public String getHelpHint() {
        return "include the important group of people deciding your project for some feedback here and there\n";
    }

    // Return a funny hint.
    @Override
    public String getFunnyHint(){
        return "Quick tip you should probably include the people who decide your paycheck\n";
    }

    // Display introduction text to the player.
    @Override
    public void introductionText() {
        System.out.println("====== SprintRetrospective room! =====");
        System.out.println();
        System.out.println("In this room, you will reflect on how a Scrum Team can learn from their experiences.");
        System.out.println("Use your knowledge to identify what can be improved by the Scrum Team.");
        System.out.println();
        interactWithObject();
    }

    // Describe scenario.
    @Override
    public void roomTask() {
        System.out.println();
        System.out.println("Scenario:");
        System.out.println("The Scrum Team showed the results of their work after several sprints,");
        System.out.println("but the stakeholders were not happy with the results.");
        System.out.println();
        JokerCommand jokerCommand = new JokerCommand(player, new GameUI());
        jokerCommand.execute();
        question();
    }

    // Check the player's answer.
    @Override
    public void roomCheckAnswer() {
        CheckAnswer checker = new CheckAnswer(new Scanner(System.in));
        this.isCorrect = checker.isAnswerCorrect("B", this);
    }

    // Displays the result of the player's answer.
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

    // Display feedback to the player if the answer is false.
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
