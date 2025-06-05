package FactoryClasses;

import Interface.HintProvider;
import classes.Room;

import java.util.Random;

// Factory pattern for creating different hintProviders.
public class HintProviderFactory {
    public static HintProvider createRandomHintProvider(Room room) {
        Random random = new Random();
        // Returns a randomized hint.
        if (random.nextBoolean()) {

            return new FunnyHintProvider(room);

        } else {

            return new HelpHintProvider(room);
        }
    }
}