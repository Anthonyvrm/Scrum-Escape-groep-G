package Testing;

import Joker.Joker;

public class RandwaardeJoker {
    public static void main(String[] args) {

        Joker joker = new Joker() {};

        assert !joker.getUsed(): "not used";
        joker.markJokerAsUsed();
        assert joker.getUsed(): "used";
        joker.markJokerAsUsed();
        System.out.println("Test passed!");

    }

}
