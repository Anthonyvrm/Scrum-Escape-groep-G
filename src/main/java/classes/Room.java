package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Room implements Subject {
    protected String name;
    protected Monster monster;
    protected boolean isCorrect;
    private List<QuestionObserver> questionObservers = new ArrayList<>();
    protected IRoom questionStrategy;
    protected HintProvider hintProvider;

    public abstract String getFunnyHint();
    public abstract String getHelpHint();

    public Room(String name, Monster monster, boolean isCorrect) {
        this.name = name;
        this.monster = monster;
        this.isCorrect = isCorrect;
    }

    public void askForHint(Scanner scanner) {
        System.out.println("Would you like a hint? Type 'Y' of 'N':");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("Y")) {
            System.out.println("Hint: " + hintProvider.getHint());
        }
    }

    public void setQuestionStrategy(IRoom questionStrategy) {
        this.questionStrategy = questionStrategy;
    }
    public void setHintProvider(HintProvider hintProvider) {
        this.hintProvider = hintProvider;
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

    public void hint () {hintProvider.getHint();}
    
    public final void runEscapeRoom() {
        introductionText();
        roomTask();
        roomCheckAnswer();
        roomResult();
        roomFeedback();
    }

    public abstract void introductionText();
    public abstract void roomTask();
    public abstract void roomCheckAnswer();
    public abstract void roomResult();
    public abstract void roomFeedback();
}