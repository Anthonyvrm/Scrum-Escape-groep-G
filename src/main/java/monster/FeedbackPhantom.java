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
    public void takeDamage(){
        int randomInt = (int)(Math.random() * 5);
        switch (randomInt) {
            case 0:
                System.out.println("Ugh... do I really have to pay attention?");
                break;
            case 1:
                System.out.println("Such a waste... just like all feedback.");
                break;
            case 2:
                System.out.println("Ugh... feedback again? Like I care...");
                break;
            case 3:
                System.out.println("Meh... even when I’m hurt, I’m still doing nothing with feedback.");
                break;
            case 4:
                System.out.println("Alright, alright... I don’t care... but that hurts.");
                break;
        }
    }

    @Override
    public void dealDamage(){
        int randomInt = (int)(Math.random() * 5);
        switch (randomInt) {
            case 0:
                System.out.println("Feel that? That's what useless feedback does!");
                break;
            case 1:
                System.out.println("Painful, isn’t it? Just like unclear expectations.");
                break;
            case 2:
                System.out.println("Let me destroy your sprint with one badly timed opinion!");
                break;
            case 3:
                System.out.println("Boom! Now you’re doubting everything you just built.");
                break;
            case 4:
                System.out.println("I just derailed your progress — you're welcome.");
                break;
        }
    }
}