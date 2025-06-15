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

        String answer = scanner.nextLine().trim();
        boolean isCorrect = answer.equalsIgnoreCase(correctAnswer);
        final int maxAttempts = 1;
        int attempts = 0;

        while (attempts < maxAttempts) {
            System.out.println("Incorrect try again ("
                    + (maxAttempts - attempts) + " attempts left):");
            room.askForHint(scanner);
            room.question();
            answer = scanner.nextLine().trim();
            attempts++;
            isCorrect = answer.equalsIgnoreCase(correctAnswer);
            if (isCorrect) {
                break;
            } else if (attempts < maxAttempts) {
                System.out.println("Incorrect try again ("
                        + (maxAttempts - attempts) + " attempts left):");
                room.askForHint(scanner);
                room.question();
                answer = scanner.nextLine().trim();
                attempts++;
                isCorrect = answer.equalsIgnoreCase(correctAnswer);
            }
        }
        // ngl brein zo hard aan het koken dat ik neit weet hoe ik dit cleaner meot maken

        if (!isCorrect) {
            System.out.println("Out of attempts! The correct answer was: "
                    + correctAnswer);
        }

        // Notify all observers about the answer.
        room.notifyObservers(isCorrect);
        // set isCorrect in room.
        room.setIsCorrect(isCorrect);
        // Navigate to next room.
        RoomNavigator navigator = Game.getGameEngine().getRoomNavigator();
        navigator.goToNextRoom();

        return isCorrect;
    }
}