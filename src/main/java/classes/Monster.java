package classes;

import java.util.ArrayList;

public abstract class Monster {
    protected int damage;
    protected int healthPoints;
    //private ArrayList<Observer> observers = new ArrayList<>();

    public Monster(int damage, int healthPoints) {
        this.damage = damage;
        this.healthPoints = healthPoints;
    }


    /*public void reduceHealthPoints(int damage){
        this.healthPoints -= damage;
        if(getHealthPoints() <= 0){
            hasDied();
            notifyObservers();
        }
    }

    @Override
    /public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(Observer::update);
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void hasDied(){
        System.out.println("You defeated the monster!");
    }*/
}