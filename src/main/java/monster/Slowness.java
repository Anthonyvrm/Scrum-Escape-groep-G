package monster;

import classes.IMonster;
import classes.Monster;


//Slowness is een schaduwachtig wezen dat zich voedt met inefficiëntie.
//Elke keer dat een teamlid afwijkt van het doel van de stand-up, groeit Slowness groter en sterker.
//Hij fluistert irrelevante updates, stelt eindeloze vragen en houdt iedereen net te lang vast in het gesprek.

//Mogelijke defeat line: "My time... has run out..."

public class Slowness implements IMonster {
    @Override
    public void exercise(){

    }

    @Override
    public void takeDamageQuote(){
        int randomInt = (int)(Math.random() * 5);
        switch (randomInt) {
            case 0:
                System.out.println("Fine... keep your 'efficiency'...");
                break;
            case 1:
                System.out.println("Your discipline... it's unbearable...");
                break;
            case 2:
                System.out.println("That was... unnecessarily direct.");
                break;
            case 3:
                System.out.println("You’re not supposed to stay on topic!");
                break;
            case 4:
                System.out.println("I was just getting comfortable...");
                break;
        }
    }

    @Override
    public void dealDamageQuote(){
        int randomInt = (int)(Math.random() * 5);
        switch (randomInt) {
            case 0:
                System.out.println("Wait... before we move on, one more thing...");
                break;
            case 1:
                System.out.println("I’m not sure this is relevant, but I’ll explain anyway...");
                break;
            case 2:
                System.out.println("This won't take long... I promise.");
                break;
            case 3:
                System.out.println("Actually, can we go back to something from last week?");
                break;
            case 4:
                System.out.println("I drain your focus... one pointless tangent at a time.");
                break;
        }

    }
}