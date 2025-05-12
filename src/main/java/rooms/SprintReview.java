package rooms;

import classes.IRoom;
import classes.Monster; //Feedback Phantom
import classes.Room;
import monster.FeedbackPhantom;

public class SprintReview extends Room implements IRoom {
    public SprintReview(String question, String objective, String name, Monster monster, boolean isCorrect){
        super(question, objective, name, monster, isCorrect);
    }

    public static void createSprintReviewRoom() {
        Monster feedbackPhantom = new FeedbackPhantom(10, 50);
        Room sprintreview = new SprintReview("Question", "Objective", "Sprint Review", feedbackPhantom, false);
    }

    @Override
    public void introductionText() {

    }

    @Override
    public void roomTask() {

    }

    @Override
    public void roomCheckAnswer() {

    }

    @Override
    public void roomResult() {

    }

    @Override
    public void roomFeedback() {

    }

    @Override
    public void multipleChoiceQuestion() {

    }

    @Override
    public void openQuestion() {

    }

    @Override
    public void puzzle() {

    }
}
