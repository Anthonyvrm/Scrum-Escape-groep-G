package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Room implements Subject {
    protected String name;
    protected Monster monster;
    protected boolean isCorrect;
    private List<QuestionObserver> questionObservers = new ArrayList<>();
    protected IRoom questionStrategy;
    protected HintProvider hintProvider;
    protected IBook bookinfo;
    protected IWeapon weapon;

    public abstract String getFunnyHint();
    public abstract String getHelpHint();

    public Room(String name, Monster monster, boolean isCorrect) {
        this.name = name;
        this.monster = monster;
        this.isCorrect = isCorrect;
    }

    public void askForHint(Scanner scanner) {
        System.out.println("Would you like a hint? Type 'Y' of 'N':");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("Y")) {
            System.out.println("Hint: " + hintProvider.getHint());
        }
    }

    public void interactWithObject() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("There are objects in front of you, would you like to use one? (Book/Weapon/No)");
        String answer = scanner.nextLine().toLowerCase();

        switch (answer) {
            case "book":
                if (bookinfo != null) {
                    bookinfo.readBook();
                } else {
                    System.out.println("There is no book in this room!");
                }
                break;
            case "weapon":
                if (weapon != null) {
                    weapon.attackWithWeapon();
                } else {
                    System.out.println("You have no weapon !");
                }
                break;
                case "no":
                    System.out.println("You decide to use no object...... not so smart....");
                    break;
            default:
                System.out.println("Invalid input! urgh....");
        }
    }

    public void setQuestionStrategy(IRoom questionStrategy) {
        this.questionStrategy = questionStrategy;
    }
    public void setHintProvider(HintProvider hintProvider) {
        this.hintProvider = hintProvider;
    }

    public String getName() {
        return name;
    }

    @Override
    public void registerObserver(QuestionObserver o) {
        questionObservers.add(o);
    }

    @Override
    public void removeObserver(QuestionObserver o) {
        questionObservers.remove(o);
    }

    @Override
    public void notifyObservers(boolean isCorrect) {
        for (QuestionObserver o : questionObservers) {
            o.update(isCorrect);
        }
    }

    public void question() {
        questionStrategy.question();
    }

    public void hint () {hintProvider.getHint();}
    
    public final void runEscapeRoom() {
        introductionText();
        roomTask();
        roomCheckAnswer();
        roomResult();
        roomFeedback();
    }

    public abstract void introductionText();
    public abstract void roomTask();
    public abstract void roomCheckAnswer();
    public abstract void roomResult();
    public abstract void roomFeedback();
}