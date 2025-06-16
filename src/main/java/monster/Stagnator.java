package monster;

import Interface.IMonster;

//Stagnator is een massief, rotsachtig monster dat elke poging tot verbetering blokkeert.
//Hij zit roerloos midden in de kamer, zwaar van gewoonte en cynisme.
//Zijn kracht? Onveranderlijkheid.
//Hij fluistert “zo doen we het altijd al” en onderdrukt initiatief, reflectie en groei.

public class Stagnator implements IMonster {
    // Prints a random quote when a monster takes damage.
    @Override
    public String[] getTakeDamageQuotes() {
        return new String[]{
                "Initiative? That’s not how we do things here.",
                "Stop trying. Nothing ever really changes.",
                "You... changed something...",
                "You moved me... barely.",
                "Stop... breaking tradition..."
        };
    }

    // Prints a random quote when a monster deals damage.
    @Override
    public String[] getDealDamageQuotes() {
        return new String[]{
                "I just buried your initiative under ten years of habit.",
                "I hit hard—with the full weight of 'how it’s always been'.",
                "That spark of change? Extinguished.",
                "Feel that? That's your motivation... crushed.",
                "Every hit reminds you: nothing ever changes."
        };
    }
}