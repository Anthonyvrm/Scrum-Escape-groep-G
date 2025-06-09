package Assistent;

import java.util.List;

public class AssistantActivator {
    private final List<AssistantAction> actions;

    //constructor
    public AssistantActivator(List<AssistantAction> actions) {
        this.actions = actions;
    }

    //activeert alle acties van de assistent
    public void activateAssistant() {
        for (AssistantAction action : actions) {
            action.execute();
        }
    }
}