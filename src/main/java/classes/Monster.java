package classes;

public abstract class Monster {
    protected int damage;
    protected int healthPoints;

    public Monster(int damage, int healthPoints){
        this.damage = damage;
        this.healthPoints = healthPoints;
    }
}
