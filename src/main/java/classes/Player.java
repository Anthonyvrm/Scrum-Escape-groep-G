package classes;
import Joker.Joker;

public class Player {
    private int status;
    private String name;
    private Room position;
    private int voortgang;
    private Joker joker;
    private Weapon weapon;

    // Constructor initializes player status, name, current room position and progress.
    public Player(int status, String name, Room position, int voortgang) {
        this.status = status;
        this.name = name;
        this.position = position;
        this.voortgang = voortgang;
    }

    // Constructor with only health and name
    public Player(int status, String name) {
        this.status = status;
        this.name = name;
    }

    // Constructor with health, name, and progress
    public Player(int status, String name, int voortgang) {
        this.status = status;
        this.name = name;
        this.voortgang = voortgang;
    }

    public Player() {
    }

    public void setWeapon(Weapon weapon) { this.weapon = weapon;}

    public Weapon getWeapon() { return this.weapon; }

    public void setJoker(Joker joker) {
        this.joker = joker;
    }

    public Joker getJoker() {
        return joker;
    }

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

    // Displays the Player's name, current hp and location.
    public void printStatus() {
        System.out.printf("%s has %dHP left and is in room %s.", getName(), getStatus(), getPosition().getName());
    }
}
