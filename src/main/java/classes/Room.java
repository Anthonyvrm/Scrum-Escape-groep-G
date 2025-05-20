package classes;

import java.util.ArrayList;
import java.util.List;

public abstract class Room implements Subject{
    protected String name;
    protected Monster monster;
    protected boolean isCorrect;
    private List<QuestionObserver> questionObservers = new ArrayList<>();

    public Room(String name, Monster monster, boolean isCorrect) {
        this.name = name;
        this.monster = monster;
        this.isCorrect = isCorrect;
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