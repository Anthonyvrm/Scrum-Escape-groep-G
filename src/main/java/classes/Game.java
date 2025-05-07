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
        showStartingDialogue();

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
