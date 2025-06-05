package classes;

import Game.Game;
import Interface.IMonster;

public class Monster {
    private int damage;
    private int healthPoints;
    private String name;
    private IMonster monsterStrategy; // Monster babababab = new Monster(5, 10, "Babababab", new ScopeCreep())

    // Constructor initializes damage, hp, name and behavior of the monster.
    public Monster(int damage, int healthPoints, String name, IMonster monsterStrategy){
        this.damage = damage;
        this.healthPoints = healthPoints;
        this.name = name;
        this.monsterStrategy = monsterStrategy;
    }

    public void monsterBattle () {

        //! Alleen opletten want elke klasse wil de oude vraag herhaald hebben. Dus hier nog goed over nadenken wat de beste methode is.
        //! Als de herhaalde vraag goed is, doen we een randomized damage tegen het monster.
        //! Dungeons and Dragons esque battle. Speler gooit een dobbelsteen op basis van nummer meer of minder damage bij monster (waarde nog even bedenken).
        //! Monster doet hetzelfde, gooit ook een dobbelsteen en doet bij de speler damage (waarde ook bedenken).
        //! Wanneer de speler onder 0 hp heeft, ben je dood.
        //! Wanneer de monster onder 0 hp heeft, krijg je een bericht dat je de monster verslagen hebt en naar de volgende kamer gaat met je hp na dit gevecht.
        //! (Optioneel) Een reward na het gevecht zodat je je hp kan herstellen.
        //! (Optioneel) Een extra interactableObject bij de kamers, zodat je je hp kan herstellen.

    }

    public void playerThrowsDice() {
        //! hier logica dat je de dobbelsteen gooit en damage krijgt.
    }

    // Getter for current monster healthPoints.
    public int getHealthPoints() {
        return healthPoints;
    }

    public void monsterThrowsDice() {
        //! hier logica dat de monster een dobbelsteen gooit en damage krijgt.
    }

    // Called when monster deals damage to the Player.
    public void dealDamage(Player player, double damageModifier){
        // Trigger monster quote.
        monsterStrategy.dealDamageQuote();

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
        monsterStrategy.takeDamageQuote();

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

    // Extra method, no usage.
    public void exercise(){
        monsterStrategy.exercise();
    }
}