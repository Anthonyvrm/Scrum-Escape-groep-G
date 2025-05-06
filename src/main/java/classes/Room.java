package classes;

public abstract class Room {
    protected String question;
    protected String objective;
    protected String name;
    protected Monster monster;

    public Room (String question, String objective, String name, Monster monster){
        this.question = question;
        this.objective = objective;
        this.name = name;
        this.monster = monster;

    }
    public Room (String question, String objective, String name) {
        this.question = question;
        this.objective = objective;
        this.name = name;
    }
}
