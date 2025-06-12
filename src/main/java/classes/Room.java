package classes;

import InteractWithObject.InteractWithObject;
import Interface.*;
import Joker.Joker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Room implements Subject {
    protected String name;
    public Monster monster;
    public boolean isCorrect;

    // List with added observers.
    private final List<QuestionObserver> questionObservers = new ArrayList<>();
    protected IRoom questionStrategy;
    protected HintProvider hintProvider;
    protected IReadable bookinfo;
    protected IWeapon weapon;
    protected InteractWithObject interactableObjects;
    protected Player player;
    protected IRewardable reward;

    // Abstract methods for hints which must be implemented by subclasses.
    public abstract String getFunnyHint();
    public abstract String getHelpHint();

    // Constructor room class initializes name, monster in room, isCorrect which means whether a question has been answered correctly.
    public Room(String name, Monster monster, boolean isCorrect, Player player) {
        this.name = name;
        this.monster = monster;
        this.isCorrect = isCorrect;
        this.player = player;
        // interactableObjects will be initialized after bookinfo, weapon, and reward are set in subclasses
    }

    // Initialize interactable objects with the current bookinfo, weapon, and reward
    protected void initializeInteractableObjects() {
        this.interactableObjects = new InteractWithObject(bookinfo, weapon, reward, monster);
    }

    // Set player in room.
    public void setPlayer(Player player) {
        this.player = player;
    }

    // KeyJoker can only be used in 2 rooms, when asking to use it in another room this method will be called.
    // Which tells the player the attempt to use the joker has been failed.
    public void applyKeyJoker(Joker joker) {

            joker.markJokerAsUsed();
            System.out.println("YOU CANNOT GET OUT LIKE THAT.");
            System.out.println();

    }

    private boolean unlockedByKey = false;

    public void setIsCorrectByKey() {
        this.isCorrect = true;
        this.unlockedByKey = true;
    }

    public boolean wasUnlockedByKey() {
        return unlockedByKey;
    }
    // Asks the player if they want a hint.
    public void askForHint(Scanner scanner) {

        System.out.println("Would you like a hint? Type 'Y' or 'N':");

        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("Y")) {
            System.out.println("Hint: " + hintProvider.getHint());

        }
    }

    // Sets whether the player's answer is correct.
    public void setIsCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    // Executes object interaction.
    public void interactWithObject() {
        if (interactableObjects != null) {
            interactableObjects.interactWithObject(this.player);
        }
}

    // Set the question strategy used in this room.
    public void setQuestionStrategy(IRoom questionStrategy) {
        this.questionStrategy = questionStrategy;
    }

    // Set the hint provider used for this room.
    public void setHintProvider(HintProvider hintProvider) {
        this.hintProvider = hintProvider;
    }

    // Get the name of the room.
    public String getName() {
        return name;
    }

    // Observer pattern methods.
    // Register observer that wants to receive notifications when a question has been answered correctly.
    @Override
    public void registerObserver(QuestionObserver o) {
        questionObservers.add(o);
    }

    // Removes an observer from the notification list.
    @Override
    public void removeObserver(QuestionObserver o) {
        questionObservers.remove(o);
    }

    // Notifies all registered observers whether the player answered the room's question correctly.
    // The observers react accordingly.
    @Override
    public void notifyObservers(boolean isCorrect) {
        for (QuestionObserver o : questionObservers) {
            o.update(isCorrect);
        }
    }

    // Ask a question specific to a room while using the chosen strategy.
    public void question() {
        questionStrategy.question();
    }

    // Template method pattern, defines the order in which the methods will be executed every subclass must use this order.
    public final void runEscapeRoom() {
        introductionText();
        roomTask();
        roomCheckAnswer();
        roomResult();
        roomFeedback();
    }

    // Abstract methods which must be used by subclasses.
    public abstract void introductionText();
    public abstract void roomTask();
    public abstract void roomCheckAnswer();
    public abstract void roomResult();
    public abstract void roomFeedback();
}
