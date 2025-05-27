package Observers;

import BattleLogic.BattleEngine;
import Interface.QuestionObserver;
import classes.Monster;
import classes.Player;

public class MonsterObserver implements QuestionObserver {
    private Monster monster;
    private Player player;

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
