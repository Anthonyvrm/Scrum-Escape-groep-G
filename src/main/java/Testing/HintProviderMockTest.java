package Testing;

import FactoryClasses.HelpHintProvider;
import FactoryClasses.HintProviderFactory;
import rooms.SprintPlanning;

public class HintProviderMockTest {
    public static void main(String[] args) {
        SprintPlanning room  = new SprintPlanning(null,false,null,null);
        HelpHintProviderMock mock = new HelpHintProviderMock(room);

        if (mock.getHint().equals("This is the mock hint!")) {
            System.out.println("Test passed!");
        } else {
            System.out.println("Test failed!");
        }
    }
}
