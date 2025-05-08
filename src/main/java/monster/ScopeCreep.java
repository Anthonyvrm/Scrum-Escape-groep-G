package monster;

import classes.IMonster;
import classes.Monster;


//Scope Creep verstoort de focus van het team, maakt het sprintdoel onhaalbaar en zorgt ervoor dat de planning voortdurend verandert.
//Voor je het weet zit je sprint vol met werk dat nooit is besproken of geprioriteerd.


public class ScopeCreep extends Monster implements IMonster {
    public ScopeCreep(int damage, int healthPoints) {
        super(damage, healthPoints);
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
