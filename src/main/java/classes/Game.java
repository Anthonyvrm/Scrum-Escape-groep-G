package classes;

public class Game {
    Player player;
    Room room;

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

    }

    public static void endGame(){
        System.exit(0);
    }
}
