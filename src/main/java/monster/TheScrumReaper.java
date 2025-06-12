package monster;

import Interface.IMonster;

public class TheScrumReaper implements IMonster {
    // Prints a random quote when a monster takes damage.
    @Override
    public void takeDamageQuote(){
        int randomInt = (int)(Math.random() * 5);
        switch (randomInt) {
            case 0:
                System.out.println("Transparency... it blinds me!");
                break;
            case 1:
                System.out.println("No! Not self-reflection!");
                break;
            case 2:
                System.out.println("You inspect... and expose my rot!");
                break;
            case 3:
                System.out.println("Stop adapting! Embrace the rot!");
                break;
            case 4:
                System.out.println("You dare shine the light of inspection on me?");
                break;
        }
    }

    // Prints a random quote when a monster deals damage.
    @Override
    public void dealDamageQuote(){

        int randomInt = (int)(Math.random() * 5);
        switch (randomInt) {
            case 0:
                System.out.println("Inspect this chaos!");
                break;
            case 1:
                System.out.println("Your board lies to you.");
                break;
            case 2:
                System.out.println("I erase your sprint backlog… line by line.");
                break;
            case 3:
                System.out.println("Your transparency has been… redacted.");
                break;
            case 4:
                System.out.println("I turn every review into ritual... without purpose.");
                break;

        }
    }
}