package classes;
import java.util.Scanner;

public class Player {

    private int status;
    private String name;
    private Room position;

    public Player (int status, String name, Room position) {
        this.status = status;
        this.name = name;
        this.position = position;
    }
    public Player (int status, String name) {
        this.status = status;
        this.name = name;
    }
    public Player () {}

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {

        return this.status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void createCharacter () {

        System.out.println("Starting Character Creation...");
        System.out.println();
        System.out.println("Create your character!");
        System.out.println("");
        whatIsYourName();
        setStatus(150);

    }

    public void whatIsYourName() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("What is your name: ");
        String name = scanner.nextLine();
        setName(name);
        System.out.println();

    }

    public void showStartingDialogue() {

        System.out.printf("%s.........\n", getName());
        System.out.println("Wait I know you....");
        System.out.printf("You are %s! You are one of the wisest beings to ever exist in this realm!\n", getName());
        System.out.println("You... You are the chosen one! You are the only one who can escape these horrifying rooms.....");
        System.out.println();
        System.out.printf("%s.... Are you sure, you want to start this journey?\n", getName());
        System.out.println("Oh wait, you have no choice..... WHAHAAHA!");

    }

    public void printStatus() {
        System.out.printf("%s has %dHP left and is in room %s.", getName(), getStatus(), position);
    }

    public void isAlive(){
        if(status <= 0) {
            System.out.println("G A M E   O V E R . . .");
            Game.endGame();
        }
    }
}

