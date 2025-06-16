package rooms;

import Game.Game;
import classes.Room;
import classes.RoomNavigator;

import java.util.Scanner;

public class CheckAnswer {
    private final Scanner scanner;
    public Game game;

    // Constructor CheckAnswer.
    public CheckAnswer(Scanner scanner) {
        this.scanner = scanner;
    }

    // Check if player input is the correct answer.
    public boolean isAnswerCorrect(String correctAnswer, Room room) {
        final int maxAttempts = 2;  // Changed to 2 since you want one retry
        int attempts = 0;
        boolean isCorrect = false;

        do {
            if (attempts > 0) {
                System.out.println();
                System.out.println("Incorrect try again (" +
                        (maxAttempts - attempts) + " attempts left):");
                room.askForHint(scanner);
                room.question();
            }

            String answer = scanner.nextLine().trim();
            isCorrect = answer.equalsIgnoreCase(correctAnswer);
            attempts++;

        } while (!isCorrect && attempts < maxAttempts);

        if (!isCorrect) {
            System.out.println();
            System.out.println("Out of attempts! The correct answer was: " + correctAnswer);
        }

        // Handle room completion
        room.notifyObservers(isCorrect);
        room.setIsCorrect(isCorrect);
        RoomNavigator navigator = Game.getGameEngine().getRoomNavigator();
        navigator.goToNextRoom();

        return isCorrect;
    }
}