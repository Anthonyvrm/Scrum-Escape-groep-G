package classes;

public class MonsterObserver implements Observer{
    private Monster monster;

    public MonsterObserver(Monster monster) {
        this.monster = monster;
    }

    @Override
    public void update(boolean isCorrect) {
        //System.out.println(monster.getClass().getSimpleName() + " has " + monster.getHealthPoints() + " HP left.");
    }
}
