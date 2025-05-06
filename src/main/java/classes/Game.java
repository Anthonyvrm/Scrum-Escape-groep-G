package classes;

public class Game {
    Player player;
    Room room;

    public Game (Room room, Player player) {
        this.room = room;
        this.player = player;
    }

    public Game () {
        this.room = room;
        this.player = player;
    }

    public void startGame() {

        System.out.println("==== Scrum Escape Building ===");
        System.out.println();


    }

    public static void endGame(){
        System.exit(0);
    }
}
