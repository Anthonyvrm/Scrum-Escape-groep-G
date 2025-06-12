package Assistent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AssistantActivator {
    private List<AssistantAction> actions;

    public AssistantActivator() {

    }

    //activeert alle acties van de assistent
    public void activateAssistant() {
        for (AssistantAction action : actions) {
            action.execute();
        }
    }

    //Maakt een lijst met alle acties van de Assistent
    public List<AssistantAction> createAssistantActions(String hint, String educationalTool, String quote) {
        List<AssistantAction> actions = new ArrayList<>();
        actions.add(() -> System.out.println("Hint: " + hint));
        actions.add(() -> System.out.println("Educational tool: " + educationalTool));
        actions.add(() -> System.out.println("Motivationalquote: " + quote));
        return actions;
    }

    //Setter voor de lijst met acties
    public void setActions(List<AssistantAction> actions) {
        this.actions = actions;
    }

    //Vraagt de gebruiker om een assistent te activeren
    public void askForAssistance() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to get some assistance? (Y/N)");
        if (scanner.nextLine().equalsIgnoreCase("Y")) {
            System.out.println("Great! We will help you out.");
            this.activateAssistant();
        }
    }
}