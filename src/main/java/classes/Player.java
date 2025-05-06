package classes;
import java.util.Scanner;

public class Player {

    private String status;
    private String name;
    private String position;

    public Player (String status, String name, String position) {
        this.status = status;
        this.name = name;
        this.position = position;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void whatisyourname() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = scanner.nextLine();
        setName(name);


    }
}

