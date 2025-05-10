package monster;

import classes.IMonster;
import classes.Monster;


//FeedBack Phantom is een spookachtig wezen dat verschijnt zodra het team feedback ontvangt… maar er niets mee doet.
//Hij spookt door de kamer met vage opmerkingen, onduidelijke verwachtingen en eindeloze meningen zonder actie.
//Hoe meer ongebruikte feedback, hoe sterker hij wordt.

public class FeedbackPhantom implements IMonster {
    @Override
    public void exercise(){

    }

    @Override
    public static void takeDamage(){
        int randomInt = (int)(Math.random() * 5);
        switch (randomInt) {
            case 0: System.out.println("Ugh... do I really have to pay attention?");
            case 1: System.out.println("Such a waste... just like all feedback.");
            case 2: System.out.println("Ugh... feedback again? Like I care...");
            case 3: System.out.println("Meh... even when I’m hurt, I’m still doing nothing with feedback.");
            case 4: System.out.println("Alright, alright... I don’t care... but that hurts.");
        }
    }

    @Override
    public void dealDamage(){

    }
}