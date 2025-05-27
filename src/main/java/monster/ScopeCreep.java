package monster;

import Interface.IMonster;

//Scope Creep verstoort de focus van het team, maakt het sprintdoel onhaalbaar en zorgt ervoor dat de planning voortdurend verandert.
//Voor je het weet zit je sprint vol met werk dat nooit is besproken of geprioriteerd.

//Mogelijke defeat line: "This isn't over — I’ll be back next sprint planning..."

public class ScopeCreep implements IMonster {
    @Override
    public void exercise(){

    }

    @Override
    public void takeDamageQuote(){
        int randomInt = (int)(Math.random() * 5);
        switch (randomInt) {
            case 0:
                System.out.println("You're hurting my creativity!");
                break;
            case 1:
                System.out.println("No fair! I was about to add five more tasks!");
                break;
            case 2:
                System.out.println("You mean... you actually stuck to the backlog?");
                break;
            case 3:
                System.out.println("Hey! That change request was important!");
                break;
            case 4:
                System.out.println("Stick to the goal, and you kill me...");
                break;
        }
    }

    @Override
    public void dealDamageQuote(){
        int randomInt = (int)(Math.random() * 5);
        switch (randomInt) {
            case 0:
                System.out.println("Let’s do everything, right now!");
                break;
            case 1:
                System.out.println("This task wasn’t here before? Surprise!");
                break;
            case 2:
                System.out.println("Oh, and just one more thing...");
                break;
            case 3:
                System.out.println("It wasn’t in the plan? It is now.");
                break;
            case 4:
                System.out.println("Planning? That’s cute.");
                break;
        }
    }
}