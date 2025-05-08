package classes;

import rooms.*;

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


    public void startGame() {

        System.out.println();
        System.out.println("Starting game...");
        System.out.println("==== Scrum Escape Building ===");
        System.out.println();
        showStartingDialogue();

        SprintPlanning.createRoom();
        TheDailyScrum.createRoom();
        ScrumBoard.createRoom();
        SprintReview.createRoom();
        SprintRetrospective.createRoom();
        TIARoom.createRoom();

        Room room = SprintPlanning.sprintPlanningRoom;
        player.setPosition(room);
        System.out.println("You have entered the " + player.getPosition().name);

        while(true) {
            System.out.println();
            String input = scanner.nextLine();
            handleCommands(input);
        }
    }

    public void handleCommands(String input){
        switch (input) {
            case "go to room SprintPlanning":
                Room room0 = SprintPlanning.sprintPlanningRoom;
                player.setPosition(room0);
                System.out.println("You have entered the SprintPlanning room.");
                break;
            case "go to room TheDailyScrum":
                Room room1 = TheDailyScrum.theDailyScrumRoom;
                player.setPosition(room1);
                System.out.println("You have entered the TheDailyScrum room.");
                break;
            case "go to room ScrumBoard":
                Room room2 = ScrumBoard.scrumBoardRoom;
                player.setPosition(room2);
                System.out.println("You have entered the ScrumBoard room.");
                break;
            case "go to room SprintReview":
                Room room3 = SprintReview.sprintReviewRoom;
                player.setPosition(room3);
                System.out.println("You have entered the SprintReview room.");
                break;
            case "go to room SprintRetrospective":
                Room room4 = SprintRetrospective.sprintRetrospectiveRoom;
                player.setPosition(room4);
                System.out.println("You have entered the SprintRetrospective room.");
                break;
            case "go to room TIARoom":
                Room room5 = TIARoom.TIARoomRoom;
                player.setPosition(room5);
                System.out.println("You have entered the TIARoom room.");
                break;
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