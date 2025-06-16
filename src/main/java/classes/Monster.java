package classes;

import Game.Game;
import Interface.IMonster;

import java.util.Random;

public class Monster {
    private final int damage;
    private int healthPoints;
    private final String name;
    private final IMonster monsterStrategy;

    // Constructor initializes damage, hp, name and behavior of the monster.
    public Monster(int damage, int healthPoints, String name, IMonster monsterStrategy){
        this.damage = damage;
        this.healthPoints = healthPoints;
        this.name = name;
        this.monsterStrategy = monsterStrategy;
    }

    public String getName() {
        return name;
    }

    // Getter for current monster healthPoints.
    public int getHealthPoints() {
        return healthPoints;
    }

    public int getDamage() { return damage; }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    // Called when monster deals damage to the Player.
    public void dealDamage(Player player, double damageModifier){

        // Trigger monster quote.
        System.out.print(name + ": ");

        damageQuote(monsterStrategy.getDealDamageQuotes());

        // Calculate final damage.
        int finalDamage = (int) (damage * damageModifier);

        // Apply damage to the Player.
        player.setStatus(player.getStatus() - finalDamage);

        // Check if the player has been defeated, show Game Over message and end the game.
        if(player.getStatus() <= 0) {

            System.out.println("You have been defeated by " + name + "!");
            System.out.println("G A M E   O V E R . . .");

            Game.endGame();
        }
        else {
            //mogelijke observer notifier.
        }
    }

    // Called when the Player deals damage to the monster.
    public void takeDamage(int damage){

        // Trigger monster quote.
        System.out.print(name + ": ");
        damageQuote(monsterStrategy.getTakeDamageQuotes());


        // Reduce monster hp.
        healthPoints -= damage;

        // Check if the monster has been defeated and show a message.
        if(healthPoints <= 0) {
            System.out.println("You have defeated " + name + "!");
        }
        else {
            //mogelijke observer notifier.
        }
    }

    public void damageQuote(String[] quotes) {
        System.out.println(quotes[new Random().nextInt(quotes.length)]);
    }
}