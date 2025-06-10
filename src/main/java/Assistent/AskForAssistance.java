package Assistent;
import java.util.Scanner;

public class AskForAssistance {
    static AssistantActivator assistant;
    
    public AskForAssistance(AssistantActivator assistant) {
        this.assistant = assistant;
    }
    //! Liefst geen static methode, we kunnen hetzelfde doen als in interactibleobject?
    public static void askForAssistance() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Would you like to get some assistance? (Y/N)");
            if (scanner.nextLine().equalsIgnoreCase("Y")) {
                System.out.println("Great! We will help you out.");
                assistant.activateAssistant();
            }
        }
    }