package Observers;

import BattleLogic.BattleEngine;
import Interface.QuestionObserver;
import classes.Monster;
import classes.*;

public class MonsterObserver implements QuestionObserver {
    private final Monster monster;
    private final Player player;
    private final Room room;
    private int wrongAttempts = 0;
    private static final int MAX_WRONG_ATTEMPTS = 3;


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
            wrongAttempts++;
            System.out.println("Incorrect answer! Attempts so far: " + wrongAttempts);

            if (wrongAttempts >= MAX_WRONG_ATTEMPTS) {
                System.out.println(monster.getName() + " appeared after too many wrong answers!");
                BattleEngine battleEngine = new BattleEngine(player, monster);
                battleEngine.startBattle(room, player);
            } else {
                System.out.println("Please try again!");
                // At this point the game should ask the question again.
                // Your game loop / Room class must allow re-asking.
            }

        } else {
            // Correct answer → reset counter
            wrongAttempts = 0;
            System.out.println(monster.getName() + " vanished!");
            System.out.println();
        }
    }

}
