package rooms;

import BattleLogic.BattleEngine;
import Commands.JokerCommand;
import Game.GameUI;
import Interface.IRoom;
import StrategyClasses.OpenQuestion;
import classes.*;
import java.util.Scanner;



public class SprintPlanning extends Room implements IRoom {
    public SprintPlanning(Monster monster, boolean isCorrect, Player player) {
        super("Sprintplanning Room", monster, isCorrect, player);
        setQuestionStrategy(new OpenQuestion("To assign story points to tasks, what is the name of the game you play with the team?"));
        setHintProvider(FactoryClasses.HintProviderFactory.createRandomHintProvider(this));
        //!Dit is wat in het boek staat.
        this.bookinfo = new BookInfo("It says: " + "What a horrible day, this room is full with calenders! This room is all about planning!");
        //!Dit is het wapen wat je mee krijgt, kunnen we van alles mee doen in specifieke kamers.
        this.weapon = new Weapon();
        this.reward = new RoomReward();
        this.interactableObjects = new InteractWithObject(bookinfo, weapon, reward);

        // what the helli
        //lol vgm can dit het fixen ja dat dus moment

    }

    @Override
    public String getHelpHint() {
        return "It’s a collaborative estimation technique where everyone 'plays' a card — and it’s not at a casino.";
    }

    @Override
    public String getFunnyHint(){
        return "Come on, I bet you plan to go to the casino soon!";
    }

    @Override
    public void introductionText() {
        System.out.println("======== Sprint Planning Room ======== ");
        System.out.println("Welcome to the Sprint Planning room!");
        System.out.println(" ");

        //!Hier pak je het object op. Deze methode staat in de abstracte klasse Room. (Wist geen betere plek).
        interactWithObject();
    }

    @Override
    public void roomTask() {
        System.out.println("The team is waiting at the table for you.");
        System.out.println("The tasks are overwhelming... we have no idea how to plan this.");
        System.out.println("And someone just realized—we've forgotten the name of the game!");
        System.out.println("*A voice breaks from the corner, barely holding back tears*");
        System.out.println("We need your help, Scrum Master.....");

        System.out.println(" ");
        JokerCommand jokerCommand = new JokerCommand(player, new GameUI());
        jokerCommand.execute();
        question();
    }

    @Override
    public void roomCheckAnswer() {
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine().trim();

        if (answer.equalsIgnoreCase("Planning Poker")) {
            isCorrect = true;
            notifyObservers(isCorrect);
        } else {
            isCorrect = false;
            askForHint(scanner);
            notifyObservers(isCorrect);
            //!hier wordt nu het monster gevecht aangeroepen, eerst met dezelfde vraag die eerder is gesteld. daarna het monstergevecht.



        }
    }

    @Override
    public void roomResult() {
        if (isCorrect) {
            System.out.println();
            System.out.println("The room falls silent...");
            System.out.println("A cold wind brushes past. The lights flicker.");
            System.out.println();
            System.out.println("Correct... You remembered the forbidden ritual: *Planning Poker*.");
            System.out.println("It's the only way to unveil the true weight of the tasks that haunt this sprint.");
            System.out.println("Only then can we hope to survive... and finish before the deadline claims us.");
            System.out.println("Thank you Scrum Master you have saved us....");
            System.out.println();
        } else {

            System.out.println();
            System.out.println("Incorrect. You hear a scary sound behind you...");
            System.out.println("You look behind you and , a wild Scope Screep appears!");
            System.out.println();




        }
    }

    @Override
    public void roomFeedback() {
        if (!isCorrect) {
            System.out.println("The correct answer was: Planning Poker.");
            System.out.println("In Scrum, Planning Poker is a technique used to estimate the effort required for tasks.");
            System.out.println("It helps the team agree on task complexity and effort.");
            System.out.println("This helps the team plan effectively and keep the project on schedule.");
            System.out.println();
        }
    }
}