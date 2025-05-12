package classes;


import rooms.*;
import database.*;

import java.util.Scanner;

public class Game {
    Player player;
    Room room;
    Scanner scanner = new Scanner(System.in);



    public Game (Room room, Player player) {
        this.room = room;
        this.player = player;
    }
    public Game (Player player) {
        this.player = player;
    }

    public Game () {}

    public void createRooms() {
        System.out.println("Creating rooms...");
        ScrumBoard.createScrumBoardRoom();
        SprintPlanning.createSprintPlanningRoom();
        SprintRetrospective.createSprintRetrospectiveRoom();
        SprintReview.createSprintReviewRoom();
        TheDailyScrum.createTheDailyScrumRoom();
        //TIARoom.createTIARoom();
    }


    public void startGame() {

        System.out.println();
        System.out.println("Starting game...");
        System.out.println("==== Scrum Escape Building ===");
        System.out.println();
        showStartingDialogue();

        SprintPlanning.createSprintPlanningRoom();
        Room room = SprintPlanning.sprintPlanningRoom;
        player.setPosition(room);
        System.out.println("You have entered the " + player.getPosition().name);

        while(true) {
            System.out.println();
            String input = scanner.nextLine();
            handleCommands(input);
        }
        if (room.isCorrect()) {
            System.out.println("You have completed the room!");
            System.out.println("You can now go to the next room.");
            database.saveDAO.insertSave(player);



        } else {
            System.out.println("You have failed the room.");
            endGame();
        }
    }

    public void handleCommands(String input){
        switch (input) {
            case "go to room SprintPlanning":
                SprintPlanning.createSprintPlanningRoom();
                Room room = SprintPlanning.sprintPlanningRoom;
                player.setPosition(room);
                System.out.println("You have entered the SprintPlanning room.");
                break;
                /*
            case "go to room TheDailyScrum":
                player.setPosition(new TheDailyScrum());
                System.out.println("You have entered the TheDailyScrum room.");
                break;
            case "go to room ScrumBoard":
                player.setPosition(new ScrumBoard());
                System.out.println("You have entered the ScrumBoard room.");
                break;
            case "go to room SprintReview":
                player.setPosition(new SprintReview());
                System.out.println("You have entered the SprintReview room.");
                break;
            case "go to room SprintRetrospective":
                player.setPosition(new SprintRetrospective());
                System.out.println("You have entered the SprintRetrospective room.");
                break;
            case "go to room TIARoom":
                player.setPosition(new TIARoom());
                System.out.println("You have entered the TIARoom room.");
                break;*/
        }
    }

    public void showStartingDialogue() {

        System.out.printf("%s.........\n", player.getName());
        System.out.println("Wait I know you....");
        System.out.printf("You are %s! You are one of the wisest beings to ever exist in this realm!\n", player.getName());
        System.out.println("You... You are the chosen one! You are the only one who can escape these horrifying rooms.....");
        System.out.println();
        System.out.printf("%s.... Are you sure, you want to start this journey?\n", player.getName());
        System.out.println("Oh wait, you have no choice..... WHAHAAHA!");

    }



    public static void endGame(){
        System.exit(0);
    }
}