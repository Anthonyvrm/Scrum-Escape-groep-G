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

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void whatIsYourName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = scanner.nextLine();
        setName(name);
    }

    public void printStatus() {
        System.out.printf("%s has %dHP left and is in room %s.", name, status, position);
    }

    public void isAlive(){
        if(status <= 0) {
            System.out.println("G A M E   O V E R . . .");
            Game.endGame();
        }
    }
}

