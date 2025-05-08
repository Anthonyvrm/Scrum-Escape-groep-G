package monster;

import classes.IMonster;
import classes.Monster;


//FeedBack Phantom is een spookachtig wezen dat verschijnt zodra het team feedback ontvangt… maar er niets mee doet.
//Hij spookt door de kamer met vage opmerkingen, onduidelijke verwachtingen en eindeloze meningen zonder actie.
//Hoe meer ongebruikte feedback, hoe sterker hij wordt.

public class FeedbackPhantom extends Monster implements IMonster {
    FeedbackPhantom(int damage, int healthPoints){
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