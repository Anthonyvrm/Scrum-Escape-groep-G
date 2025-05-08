package monster;

import classes.IMonster;
import classes.Monster;


//Slowness is een schaduwachtig wezen dat zich voedt met inefficiëntie.
//Elke keer dat een teamlid afwijkt van het doel van de stand-up, groeit Slowness groter en sterker.
//Hij fluistert irrelevante updates, stelt eindeloze vragen en houdt iedereen net te lang vast in het gesprek.


public class Slowness extends Monster implements IMonster {
    public Slowness(int damage, int healthPoints) {
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