package monster;

import Interface.IMonster;

//Trollo is een chaotische trol dat door digitale borden kruipt, kaartjes versleept en verantwoordelijkheden vervaagt.
//Hij leeft van onduidelijke statusupdates, vergeten taken en kaarten zonder eigenaar.
//Zijn aanwezigheid zorgt ervoor dat niemand nog weet wat “To Do”, “Doing” of “Done” betekent.

public class Trollo implements IMonster {
    // Prints a random quote when a monster takes damage.
    @Override
    public String[] getTakeDamageQuotes() {
        return new String[]{
                "Are you updating the board?! Stop that!",
                "Labels? Assignments? Noooo!",
                "You can’t just... drag cards correctly!",
                "A checklist? That’s cheating!",
                "Wait — you're organizing?!"
        };
    }

    // Prints a random quote when a monster deals damage.
    @Override
    public String[] getDealDamageQuotes() {
        return new String[]{
                "Oops! I moved your critical task to 'Later... maybe'.",
                "To Do? Doing? Who’s asking?",
                "I just archived your priority. You’re welcome.",
                "Let’s rename everything and act like it makes sense.",
                "I replaced your status labels... with emojis!"
        };
    }
}