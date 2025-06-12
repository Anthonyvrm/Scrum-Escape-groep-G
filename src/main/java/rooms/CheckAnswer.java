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

        // If answer is incorrect give a hint.
        if (!isCorrect) {
            room.askForHint(scanner);
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