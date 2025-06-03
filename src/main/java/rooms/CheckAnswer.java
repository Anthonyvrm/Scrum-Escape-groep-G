package rooms;

import classes.Room;

import java.util.Scanner;

public class CheckAnswer {
    private final Scanner scanner;

    public CheckAnswer(Scanner scanner) {
        this.scanner = scanner;
    }

    public boolean isAnswerCorrect(String correctAnswer, Room room) {
        String answer = scanner.nextLine();
        boolean isCorrect = answer.equalsIgnoreCase(correctAnswer);

        if (!isCorrect) {
            room.askForHint(scanner);
        }

        room.notifyObservers(isCorrect);
        return isCorrect;
    }
}