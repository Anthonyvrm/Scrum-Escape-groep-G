package BattleLogic;

import Commands.NextRoomCommand;
import Commands.*;
import Commands.StatusCommand;
import Game.GameInputHandler;
import Game.GameUI;
import classes.*;
import classes.RoomNavigator;

import java.util.Scanner;

public class BattleEngine {
    private final Player player;

    private final BattleInputHandler inputHandler;
    private final Monster monster;
    public BattleEngine(Player player, Monster monster) {
        this.player = player;

        this.inputHandler = new BattleInputHandler(new java.util.Scanner(System.in));
        this.monster = monster;
        setupCommands();
    }


    private void setupCommands() {
        inputHandler.registerCommand("Attack", new SlashCommand(player, monster));
        inputHandler.registerCommand("Block", new BlockCommand(player, monster));
    }
    public void runBattle() {
        while (true) {
            inputHandler.handleInput();
        }
    }
    public void startBattle() {
        player.printStatus();
        System.out.println(monster.getHealthPoints());
        System.out.println("You are now in battle!");
        runBattle();
    }
}
