package monster;

import Interface.IMonster;

//Slowness is een schaduwachtig wezen dat zich voedt met inefficiëntie.
//Elke keer dat een teamlid afwijkt van het doel van de stand-up, groeit Slowness groter en sterker.
//Hij fluistert irrelevante updates, stelt eindeloze vragen en houdt iedereen net te lang vast in het gesprek.

//Mogelijke defeat line: "My time... has run out..."

public class Slowness implements IMonster {
    // Prints a random quote when a monster takes damage.
    @Override
    public String[] getTakeDamageQuotes() {
        return new String[]{
                "Fine... keep your 'efficiency'...",
                "Your discipline... it's unbearable...",
                "That was... unnecessarily direct.",
                "You’re not supposed to stay on topic!",
                "I was just getting comfortable..."
        };
    }

    // Prints a random quote when a monster deals damage.
    @Override
    public String[] getDealDamageQuotes() {
        return new String[]{
                "Wait... before we move on, one more thing...",
                "I’m not sure this is relevant, but I’ll explain anyway...",
                "This won't take long... I promise.",
                "Actually, can we go back to something from last week?",
                "I drain your focus... one pointless tangent at a time."
        };
    }
}