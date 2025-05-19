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

    public void dealDamage(){
        monsterStrategy.dealDamage();
    }

    public void takeDamage(){
        monsterStrategy.takeDamage();
    }

    public void exercise(){
        monsterStrategy.exercise();
    }
}
