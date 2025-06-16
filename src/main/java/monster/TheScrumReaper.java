package monster;

import Interface.IMonster;

public class TheScrumReaper implements IMonster {
    // Prints a random quote when a monster takes damage.
    @Override
    public String[] getTakeDamageQuotes() {
        return new String[]{
                "Transparency... it blinds me!",
                "No! Not self-reflection!",
                "You inspect... and expose my rot!",
                "Stop adapting! Embrace the rot!",
                "You dare shine the light of inspection on me?"
        };
    }

    // Prints a random quote when a monster deals damage.
    @Override
    public String[] getDealDamageQuotes() {
        return new String[]{
                "Inspect this chaos!",
                "Your board lies to you.",
                "I erase your sprint backlog… line by line.",
                "Your transparency has been… redacted.",
                "I turn every review into ritual... without purpose."
        };
    }
}