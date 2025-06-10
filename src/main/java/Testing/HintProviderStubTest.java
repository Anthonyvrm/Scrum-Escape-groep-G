package Testing;

import rooms.SprintPlanning;

public class HintProviderStubTest {
    public static void main(String[] args) {

        HelpHintProviderStub helpHintProviderStub = new HelpHintProviderStub(new SprintPlanning(null,false,null,null));

        helpHintProviderStub.getHint();

        if(helpHintProviderStub.getHint() != null && helpHintProviderStub.getHint().equals("It’s a collaborative estimation technique where everyone 'plays' a card — and it’s not at a casino.\n")) {
            System.out.println("Test passed! Hint is received!");
        } else {
            System.out.println("Test failed! Hint is not received");
        }

    }
}
