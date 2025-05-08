package monster;

import classes.IMonster;
import classes.Monster;

//Trollo is een chaotische trol dat door digitale borden kruipt, kaartjes versleept en verantwoordelijkheden vervaagt.
//Hij leeft van onduidelijke statusupdates, vergeten taken en kaarten zonder eigenaar.
//Zijn aanwezigheid zorgt ervoor dat niemand nog weet wat “To Do”, “Doing” of “Done” betekent.


public class Trollo extends Monster implements IMonster {
    Trollo(int damage, int healthPoints){
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