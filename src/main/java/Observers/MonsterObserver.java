package Observers;

import BattleLogic.BattleEngine;
import Interface.QuestionObserver;
import classes.Monster;
import classes.*;

public class MonsterObserver implements QuestionObserver {
    private Monster monster;
    private Player player;
    private Room room;

    // Constructor MonsterObserver.
    public MonsterObserver(Monster monster, Player player, Room room) {
        this.monster = monster;
        this.player = player;
        this.room = room;
    }

    // Called when the question's answer is updated.
    @Override
    public void update(boolean isCorrect) {
        if (!isCorrect) {
            // If the answer is wrong, the monster appears and battle starts.
            System.out.println(monster.getClass().getSimpleName() + " appeared!");
            BattleEngine battleEngine = new BattleEngine(player, monster);
            battleEngine.startBattle(room, player);
        }
        // Notify player when monster is defeated.
        else if (monster.getHealthPoints() <= 0) {
            System.out.println("Monster already defeated.");
        }
        else {
            System.out.println(monster.getClass().getSimpleName() + " vanished!");
        }
    }
}
