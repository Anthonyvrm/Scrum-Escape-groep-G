package monster;

import Interface.IMonster;

//Scope Creep verstoort de focus van het team, maakt het sprintdoel onhaalbaar en zorgt ervoor dat de planning voortdurend verandert.
//Voor je het weet zit je sprint vol met werk dat nooit is besproken of geprioriteerd.

//Mogelijke defeat line: "This isn't over — I’ll be back next sprint planning..."

public class ScopeCreep implements IMonster {
    // Prints a random quote when a monster takes damage.
    @Override
    public String[] getTakeDamageQuotes(){
        return new String[]{
                "You're hurting my creativity!",
                "No fair! I was about to add five more tasks!",
                "You mean... you actually stuck to the backlog?",
                "Hey! That change request was important!",
                "Stick to the goal, and you kill me..."
        };
    }

    // Prints a random quote when a monster deals damage.
    @Override
    public String[] getDealDamageQuotes(){
        return new String[]{
                "Let's do everything, right now!",
                "This task wasn't here before? Surprise!",
                "Oh, and just one more thing...",
                "It wasn't in the plan? It is now.",
                "Planning? That's cute."
        };
    }
}