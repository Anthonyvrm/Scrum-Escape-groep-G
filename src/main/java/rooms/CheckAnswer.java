package rooms;

import classes.Room;

import java.util.Scanner;

public class CheckAnswer {
    private final Scanner scanner;

    // Constructor CheckAnswer.
    public CheckAnswer(Scanner scanner) {
        this.scanner = scanner;
    }

    // Check if player input is the correct answer.
    public boolean isAnswerCorrect(String correctAnswer, Room room) {

        String answer = scanner.nextLine();
        boolean isCorrect = answer.equalsIgnoreCase(correctAnswer);

        // If answer is incorrect give a hint.
        if (!isCorrect) {
            room.askForHint(scanner);
        }

        // Notify all observers about the answer.
        room.notifyObservers(isCorrect);

        return isCorrect; // hier toch
    }
}