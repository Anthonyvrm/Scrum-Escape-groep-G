package classes;

public class Monster {
    private int damage;
    private int healthPoints;
    private String name;
    private IMonster monsterStrategy;

    public Monster(int damage, int healthPoints, String name, IMonster monsterStrategy){
        this.damage = damage;
        this.healthPoints = healthPoints;
        this.name = name;
        this.monsterStrategy = monsterStrategy;
    }

    public void dealDamage(Player player){
        monsterStrategy.dealDamageQuote();
        player.setStatus(player.getStatus() - damage);
        if(player.getStatus() <= 0) {
            System.out.println("You have been defeated by " + name + "!");
            System.out.println("G A M E   O V E R . . .");
            Game.endGame();
        }
        else {
            //mogelijke observer notifier.
        }
    }

    public void takeDamage(){
        monsterStrategy.takeDamageQuote();
        healthPoints -= 5;
        if(healthPoints <= 0) {
            System.out.println("You have defeated " + name + "!");
        }
        else {
            //mogelijke observer notifier.
        }
    }

    public void exercise(){
        monsterStrategy.exercise();
    }
}