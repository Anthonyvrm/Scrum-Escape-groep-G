package monster;

import Interface.IMonster;

//Stagnator is een massief, rotsachtig monster dat elke poging tot verbetering blokkeert.
//Hij zit roerloos midden in de kamer, zwaar van gewoonte en cynisme.
//Zijn kracht? Onveranderlijkheid.
//Hij fluistert “zo doen we het altijd al” en onderdrukt initiatief, reflectie en groei.

public class Stagnator implements IMonster {
    @Override
    public void exercise(){

    }

    // Prints a random quote when a monster takes damage.
    @Override
    public void takeDamageQuote(){

        int randomInt = (int)(Math.random() * 5);
        switch (randomInt) {
            case 0:
                System.out.println("Initiative? That’s not how we do things here.");
                break;
            case 1:
                System.out.println("Stop trying. Nothing ever really changes.");
                break;
            case 2:
                System.out.println("You... changed something...");
                break;
            case 3:
                System.out.println("You moved me... barely.");
                break;
            case 4:
                System.out.println("Stop... breaking tradition...");
                break;

        }
    }

    // Prints a random quote when a monster deals damage.
    @Override
    public void dealDamageQuote(){

        int randomInt = (int)(Math.random() * 5);
        switch (randomInt) {
            case 0:
                System.out.println("I just buried your initiative under ten years of habit.");
                break;
            case 1:
                System.out.println("I hit hard—with the full weight of 'how it’s always been'.");
                break;
            case 2:
                System.out.println("That spark of change? Extinguished.");
                break;
            case 3:
                System.out.println("Feel that? That's your motivation... crushed.");
                break;
            case 4:
                System.out.println("Every hit reminds you: nothing ever changes.");
                break;

        }
    }
}