package classes;

public class MonsterObserver implements Observer{
    private Monster monster;

    public MonsterObserver(Monster monster) {
        this.monster = monster;
    }

    @Override
    public void update() {
        System.out.println("[Observer] " + monster.getClass().getSimpleName() + " heeft nu " + monster.getHealthPoints() + " HP over.");
    }
}
