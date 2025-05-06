package classes;

public class Game {


    Player player;
    Room room;

    public Game (Room room,Player player) {
        this.room = room;

        this.player = player;
    }

    public void StartGame() {

        System.out.println("==== Scrum Escape Building ===");

    }

    public static void endGame(){
        System.exit(0);
    }
}
