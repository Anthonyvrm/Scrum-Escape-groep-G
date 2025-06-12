package Interface;

//subject to the observer pattern
public interface Subject {
    void registerObserver(QuestionObserver questionObserver);
    void removeObserver(QuestionObserver questionObserver);
    void notifyObservers(boolean isCorrect);
}