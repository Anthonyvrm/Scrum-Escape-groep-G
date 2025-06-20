package Testing;

import rooms.SprintPlanning;

public class HintProviderStubTest {
    public static void main(String[] args) {

        HelpHintProviderStub helpHintProviderStub = new HelpHintProviderStub(new SprintPlanning(null,false,null));
        helpHintProviderStub.getHint();

        if(helpHintProviderStub.getHint() != null) {
            System.out.println("Test passed! Hint is received!");
        } else {
            System.out.println("Test failed! Hint is not received");
        }

    }
}
