package classes;

public abstract class Monster {
    protected int damage;
    protected int healthPoints;
    protected IMonster monsterType;

    public Monster(int damage, int healthPoints, IMonster monsterType){
        this.damage = damage;
        this.healthPoints = healthPoints;
        this.monsterType = monsterType;
    }
}