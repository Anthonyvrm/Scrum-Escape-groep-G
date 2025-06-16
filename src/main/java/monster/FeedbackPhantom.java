package monster;

import Interface.IMonster;

//FeedBack Phantom is een spookachtig wezen dat verschijnt zodra het team feedback ontvangt… maar er niets mee doet.
//Hij spookt door de kamer met vage opmerkingen, onduidelijke verwachtingen en eindeloze meningen zonder actie.
//Hoe meer ongebruikte feedback, hoe sterker hij wordt.

public class FeedbackPhantom implements IMonster {
    // Prints a random quote when a monster takes damage.
    @Override
    public String[] getTakeDamageQuotes() {
        return new String[]{
                "Ugh... do I really have to pay attention?",
                "Such a waste... just like all feedback.",
                "Ugh... feedback again? Like I care...",
                "Meh... even when I’m hurt, I’m still doing nothing with feedback.",
                "Alright, alright... I don’t care... but that hurts."
        };
    }

    // Prints a random quote when a monster deals damage.
    @Override
    public String[] getDealDamageQuotes(){
        return new String[]{
                "Feel that? That's what useless feedback does!",
                "Painful, isn’t it? Just like unclear expectations.",
                "Let me destroy your sprint with one badly timed opinion!",
                "Boom! Now you’re doubting everything you just built.",
                "I just derailed your progress — you're welcome."
        };
    }
}