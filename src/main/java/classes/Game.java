package classes;

import java.util.*;
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

    //Variabelen voor vaste kamer volgorde
    private List<Room> rooms;
    private int currentRoomIndex = 0;

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void playerStartingPosition(Room room) {
        player.setPosition(room);
        System.out.println("You have entered the " + player.getPosition().name);
        System.out.println();
        room.runEscapeRoom();
    }

    public void startGame(Room room) {
        System.out.println();
        System.out.println("Starting game...");
        System.out.println("==== Scrum Escape Building ===");
        System.out.println();
        showStartingDialogue();
        playerStartingPosition(room);
        commandLoop();
    }

    //Logica voor commando's
    private void commandLoop() {
        while (true) {
            System.out.println("- If you want to go to the next room type: Go to next");
            System.out.println("- If you want to check your status type: Status");
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("go to next")) {
                goToNextRoom();
                player.setVoortgang(player.getVoortgang() + 1);
                //saveDAO.insertSave(player);
            } else if (input.equalsIgnoreCase("status")) {
                player.printStatus();
            } else {
                System.out.println("Unknown command");
            }
        }
    }

    public void goToNextRoom() {
        Room currentRoom = rooms.get(currentRoomIndex);

        if (!currentRoom.isCorrect) {
            System.out.println("You gotta finish the room " + player.getName() + " !");
            return;
        }

        //Logica voor naar de volgende kamer gaan
        currentRoomIndex++;
        if (currentRoomIndex < rooms.size()) {
            Room nextRoom = rooms.get(currentRoomIndex);
            player.setPosition(nextRoom);
            System.out.println("You are going to the next room called: " + player.getPosition().name);
            nextRoom.runEscapeRoom();
        } else {
            System.out.println("You finished the game YIPPIEEE!");
            endGame();
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