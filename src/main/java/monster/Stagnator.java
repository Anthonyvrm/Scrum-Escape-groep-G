package monster;

import classes.IMonster;
import classes.Monster;


//Stagnator is een massief, rotsachtig monster dat elke poging tot verbetering blokkeert.
//Hij zit roerloos midden in de kamer, zwaar van gewoonte en cynisme.
//Zijn kracht? Onveranderlijkheid.
//Hij fluistert “zo doen we het altijd al” en onderdrukt initiatief, reflectie en groei.


public class Stagnator extends Monster implements IMonster {
    public Stagnator(int damage, int healthPoints){
        super(damage,healthPoints);
    }

    @Override
    public void exercise(){

    }

    @Override
    public void takeDamage(){

    }

    @Override
    public void dealDamage(){

    }
}
