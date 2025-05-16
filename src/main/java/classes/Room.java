package classes;
import rooms.ScrumBoard;

import java.util.ArrayList;
import java.util.List;

public abstract class Room implements Subject{
    protected String question;
    protected String objective;
    protected String name;
    protected Monster monster;
    protected boolean isCorrect;
    private List<Observer> observers = new ArrayList<>();

    public Room(String name, Monster monster, boolean isCorrect) {
        this.question = question;
        this.objective = objective;
        this.name = name;
        this.monster = monster;
        this.isCorrect = isCorrect;
    }
    public Room(String question, String objective, String name) {
        this.question = question;
        this.objective = objective;
        this.name = name;
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(boolean isCorrect) {
        for (Observer o : observers) {
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
