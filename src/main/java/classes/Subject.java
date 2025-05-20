package classes;

public interface Subject {
    void registerObserver(QuestionObserver questionObserver);
    void removeObserver(QuestionObserver questionObserver);
    void notifyObservers(boolean isCorrect);
}