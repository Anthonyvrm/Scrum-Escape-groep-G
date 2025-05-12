package classes;

public abstract class Room {
    protected String question;
    protected String objective;
    protected String name;
    protected Monster monster;
    protected boolean isCorrect;

    public Room(String question, String objective, String name, Monster monster, boolean isCorrect) {
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
