package FactoryClasses;

import classes.HintProvider;
import classes.Room;

import java.util.Random;

public class HintProviderFactory {
    public static HintProvider createRandomHintProvider(Room room) {
        Random random = new Random();
        if (random.nextBoolean()) {
            return new FunnyHintProvider(room);
        } else {
            return new HelpHintProvider(room);
        }
    }
}