package classes;
import java.util.Scanner;

public class Player {
    private int status;
    private String name;
    private Room position;
    private int voortgang

    public Player (int status, String name, Room position, int voortgang) {
        this.status = status;
        this.name = name;
        this.position = position;
        this.voortgang = voortgang;
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

    public void setPosition(Room room) {
        this.position = room;
    }

    public Room getPosition() {
        return this.position;
    }

    public int getVoortgang() {
        return voortgang;
    }

    public void setVoortgang(int voortgang) {
        this.voortgang = voortgang;
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