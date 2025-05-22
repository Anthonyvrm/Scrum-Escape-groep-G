package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Room implements Subject, IRoom{
    protected String name;
    protected Monster monster;
    protected boolean isCorrect;
    private static List<QuestionObserver> questionObservers = new ArrayList<>();
    protected IRoom questionStrategy;

    public Room(String name, Monster monster, boolean isCorrect, IRoom questionStrategy) {
        this.name = name;
        this.monster = monster;
        this.isCorrect = isCorrect;
        this.questionStrategy = questionStrategy;
    }
    Scanner scanner = new Scanner(System.in);

    public void setQuestionStrategy(IRoom questionStrategy) {
        this.questionStrategy = questionStrategy;
    }

    public String getName() {
        return name;
    }

    @Override
    public void registerObserver(QuestionObserver o) {
        questionObservers.add(o);
    }

    @Override
    public void removeObserver(QuestionObserver o) {
        questionObservers.remove(o);
    }

    @Override
    public void notifyObservers(boolean isCorrect) {
        for (QuestionObserver o : questionObservers) {
            o.update(isCorrect);
        }
    }

    public void question() {
        questionStrategy.question();
    }

    public void introductionText() {
        questionStrategy.introductionText();
    }
    public void roomTask() {
        questionStrategy.roomTask();
    }
    public void roomCheckAnswer() {
        this.isCorrect = questionStrategy.roomCheckAnswer(scanner);
        notifyObservers(isCorrect);
    }
    public void roomResult() {
        questionStrategy.roomResult(isCorrect);
    }
    public void roomFeedback() {
        questionStrategy.roomFeedback(isCorrect);
    }

    public final void runEscapeRoom() {
        introductionText();
        roomTask();
        roomCheckAnswer();
        roomResult();
        roomFeedback();
    }


}