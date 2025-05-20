package rooms;

import classes.IRoom;
import classes.Monster; //Scope Creep
import classes.Player;
import classes.Room;
import monster.ScopeCreep;

import java.util.Scanner;

public class SprintPlanning extends Room implements IRoom {

    public static Room sprintPlanningRoom;

    public SprintPlanning(String name, Monster monster, boolean isCorrect){
        super(name, monster, isCorrect);
    }

    @Override
    public void introductionText(){
        System.out.println("======== Sprint Planning Room ======== ");
        System.out.println("Welcome to the Sprint Planning room!");
        System.out.println(" ");

    }

    @Override
    public void roomTask() {
        System.out.println("The team is waiting at the table for you.");
        System.out.println("The tasks are overwhelming... we have no idea how to plan this.");
        System.out.println("And someone just realized—we've forgotten the name of the game!");
        System.out.println("*A voice breaks from the corner, barely holding back tears*");
        System.out.println("We need your help, Scrum Master.....");
        System.out.println(" ");
        question();
    }

    @Override
    public void roomCheckAnswer() {

        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("Planning Poker")) {
            isCorrect = true;
            notifyObservers(isCorrect);
        } else {
            isCorrect = false;
            notifyObservers(isCorrect);
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
            System.out.println(" ");
            System.out.println("Incorrect. You hear a scary sound behind you...");
            System.out.println("You look behind you and , a wild Scope Screep appears!");
            System.out.println(" ");

        }
    }

    @Override
    public void roomFeedback() {
        if (!isCorrect) {
            System.out.println("The correct answer was: Planning Poker.");
            System.out.println("In Scrum, Planning Poker is a technique used to estimate the effort required for tasks.");
            System.out.println("It helps the team agree on task complexity and effort.");
            System.out.println("This helps the team plan effectively and keep the project on schedule.");
            System.out.println(" ");
        }

    }

    @Override
    public void question() {
        System.out.println("So as the Scrum Master... You should know this!");
        System.out.println("To assign story points to tasks, what is the name of the game you play with the team?");
    }
}
