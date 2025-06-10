package Assistent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AssistantActivator {
    private List<AssistantAction> actions;

    //constructor
    public AssistantActivator(List<AssistantAction> actions) {
        this.actions = actions;
    }

    public AssistantActivator() {

    }

    //activeert alle acties van de assistent
    public void activateAssistant() {
        for (AssistantAction action : actions) {
            action.execute();
        }
    }

    public List<AssistantAction> createAssistantActions(String hint, String educationalTool, String quote) {
        List<AssistantAction> actions = new ArrayList<>();
        actions.add(() -> System.out.println("Hint: " + hint));
        actions.add(() -> System.out.println("Educational tool: " + educationalTool));
        actions.add(() -> System.out.println("Motivationalquote: " + quote));
        return actions;
    }

    public void setActions(List<AssistantAction> actions) {
        this.actions = actions;
    }

    public void askForAssistance() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to get some assistance? (Y/N)");
        if (scanner.nextLine().equalsIgnoreCase("Y")) {
            System.out.println("Great! We will help you out.");
            this.activateAssistant();
        }
    }
}