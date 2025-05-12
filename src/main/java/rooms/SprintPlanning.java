package rooms;

import classes.IRoom;
import classes.Monster; //Scope Creep
import classes.Room;
import monster.ScopeCreep;

import java.util.Scanner;

public class SprintPlanning extends Room implements IRoom {

    public static Room sprintPlanningRoom;

    public SprintPlanning(String question, String objective, String name, Monster monster, boolean isCorrect){
        super(question, objective, name, monster, isCorrect);

    }

    public static void createSprintPlanningRoom () {

        Monster scopeCreep = new ScopeCreep(10, 50);
        sprintPlanningRoom = new SprintPlanning("Question", "Objective", "Sprint Planning Room", scopeCreep, false);

    }

    @Override
    public void introductionText(){
        System.out.println("Welcome to the Sprint Planning room!");

    }

    @Override
    public void roomTask() {
        System.out.println("The team is waiting at the table for you.");
        System.out.println("What are we going to do this next sprint is everyone asking and we have no clue on how to plan this...");

    }

    @Override
    public void roomCheckAnswer() {
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("Planning Poker")) {
            isCorrect = true;
        } else {
            isCorrect = false;
        }

    }

    @Override
    public void roomResult() {
        if (isCorrect) {
            System.out.println("Correct! In order to to plan the sprint, we need to use Planning Poker.");
            System.out.println("With this we are able to plan the sprint and have an overview and see how much time a task takes.");
        } else {
            System.out.println("Incorrect. You hear a scary sound behind you...");
            System.out.println("You look behind you and , a wild Scope Screep appears!");

        }
    }

    @Override
    public void roomFeedback() {
        System.out.println("The correct answer was: Planning Poker.");
        System.out.println("In Scrum, Planning Poker is a technique to plan the sprint.");
        System.out.println("It is a technique where the team members vote on the story points of the tasks.");
        System.out.println("This helps the team to stay on track and keep the project on track.");

    }

    @Override
    public void multipleChoiceQuestion() {

    }

    @Override
    public void openQuestion() {
        System.out.println("So Scrum master, in order to give tasks story points, what is the name of the game you play with the team?");

    }

    @Override
    public void puzzle() {

    }



}
