package monster;

import classes.IMonster;
import classes.Monster;

public class TheScrumReaper implements IMonster {
    @Override
    public void exercise(){

    }

    @Override
    public void takeDamageQuote(){
        int randomInt = (int)(Math.random() * 5);
        switch (randomInt) {
            case 0:
                System.out.println("");
                break;
            case 1:
                System.out.println("");
                break;
            case 2:
                System.out.println("");
                break;
            case 3:
                System.out.println("");
                break;
            case 4:
                System.out.println("");
                break;
        }
    }

    @Override
    public void dealDamageQuote(){
        int randomInt = (int)(Math.random() * 5);
        switch (randomInt) {
            case 0:
                System.out.println("");
                break;
            case 1:
                System.out.println("");
                break;
            case 2:
                System.out.println("");
                break;
            case 3:
                System.out.println("");
                break;
            case 4:
                System.out.println("");
                break;
        }
    }
}
