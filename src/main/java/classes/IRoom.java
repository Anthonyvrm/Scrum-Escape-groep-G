package classes;

import java.util.Scanner;

public interface IRoom {
    void question();
    void introductionText();
    void roomTask();
    boolean roomCheckAnswer(Scanner scanner);
    void roomResult(boolean isCorrect);
    void roomFeedback(boolean isCorrect);
}
