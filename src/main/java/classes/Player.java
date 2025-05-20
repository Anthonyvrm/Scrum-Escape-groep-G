package classes;
import java.util.Scanner;

public class Player {
    private int status;
    private String name;
    private Room position;
    private int voortgang;

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
    public Player (int status, String name, int voortgang) {
        this.status = status;
        this.name = name;
        this.voortgang = voortgang;
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

    public void printStatus() {
        System.out.printf("%s has %dHP left and is in room %s.", getName(), getStatus(), getPosition().getName());
    }

    public void isAlive(){
        if(status <= 0) {
            System.out.println("G A M E   O V E R . . .");
            Game.endGame();
        }
    }
}