package Observers;

import Interface.QuestionObserver;
import classes.Monster;

public class MonsterObserver implements QuestionObserver {
    private Monster monster;

    public MonsterObserver(Monster monster) {
        this.monster = monster;
    }

    @Override
    public void update(boolean isCorrect) {
        if (!isCorrect) {
            System.out.println(monster.getClass().getSimpleName() + " appeared!");
        } else {
            System.out.println(monster.getClass().getSimpleName() + " vanished!");
        }
    }
}
