package classes;

import Interface.*;

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
    protected IReadable bookinfo;
    protected IWeapon weapon;
    protected InteractWithObject interactableObjects;
    protected Player player;
    protected IRewardable reward;

    public abstract String getFunnyHint();
    public abstract String getHelpHint();

    public Room(String name, Monster monster, boolean isCorrect, Player player) {
        this.name = name;
        this.monster = monster;
        this.isCorrect = isCorrect;
        this.interactableObjects = new InteractWithObject(bookinfo, weapon, reward);

    }

    public void setPlayer(Player player) {
        this.player = player;
    }


//!Joker gedrag!
    public void acceptJoker(IJoker joker) {
        joker.applyTo(this); // Default gedrag
    }

    public void askForHint(Scanner scanner) {
        System.out.println("Would you like a hint? Type 'Y' of 'N':");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("Y")) {
            System.out.println("Hint: " + hintProvider.getHint());
        }
    }

    public void setIsCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    public void interactWithObject() {
        if (interactableObjects != null) {
            interactableObjects.interactWithObject(this.player);
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