package Game;

public class GameUI {
    // Show game title.
    public static void showGameTitle() {
        System.out.println("=========== Scrum Escape ===========");
    }

    // Display starting dialogue.
    public void showStartingDialogue(String playerName) {
        System.out.printf("%s.........\n", playerName);
        System.out.println("Wait I know you....");
        System.out.printf("You are %s! You are one of the wisest beings to ever exist in this realm!\n", playerName);
        System.out.println("You... You are the chosen one! You are the only one who can escape these horrifying rooms.....");
        System.out.println();
        System.out.printf("%s.... Are you sure, you want to start this journey?\n", playerName);
        System.out.println("Oh wait, you have no choice..... WHAHAAHA!");
    }

    // Displays message to the player.
    public void showMessage(String message) {
        System.out.println(message);
    }

    // Ends the game.
    public static void endGame() {
        System.out.println("Thank you for playing!");
        System.exit(0);
    }
}

