package rooms;

import Interface.IRoom;
import StrategyClasses.OpenQuestion;
import classes.*;

import java.util.Scanner;

public class TIARoom extends Room implements IRoom {
    public TIARoom(Monster monster, boolean isCorrect) {
        super("TIA Room", monster, isCorrect);
        setQuestionStrategy(new OpenQuestion("What does the 'T' in TIA stand for?"));
        setHintProvider(FactoryClasses.HintProviderFactory.createRandomHintProvider(this));
        this.bookinfo = new BookInfo("The book is called: Transparency In Action. Why would you even be transparant to your team?");
        this.weapon = new Weapon();
    }

    @Override
    public String getHelpHint() {
        return "All the people in the SCRUM process are honest with each other";
    }

    @Override
    public String getFunnyHint(){
        return "This hint is as clear as the sky.";
    }

    @Override
    public void introductionText() {
        System.out.println("Welcome to the TIARoom!");
        System.out.println("This is the final challenge you must face before you have succeeded this test of intelligence and wisdom.");
        System.out.println("You have walked through every chamber and must now show your full understanding of the SCRUM process.");
        System.out.println("Good luck!");
        interactWithObject();
    }

    @Override
    public void roomTask() {
        System.out.println("Answer the following question about TIA, :");
        System.out.println(" ");
        question();
    }

    @Override
    public void roomCheckAnswer() {
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine().trim();

        if (answer.equalsIgnoreCase("Transparency")) {
            isCorrect = true;
            notifyObservers(isCorrect);
        } else {
            isCorrect = false;
            askForHint(scanner);
            notifyObservers(isCorrect);
        }
    }

    @Override
    public void roomResult() {
        if (isCorrect) {
            System.out.println("You have completed the TIARoom challenge and the SCRUM game!");
        } else {
            System.out.println("You have failed!");
            //!Summon monster
            System.out.println("The BOSS monster has appeared in the TIARoom!!!");
        }
    }

    @Override
    public void roomFeedback() {
        if (!isCorrect) {
            System.out.println("The correct answer was: Transparency.");
            System.out.println("In Scrum, Transparency is one of the three pillars.");
            System.out.println("Transparency means that all people involved in the SCRUM process are transparent with each other.");
            System.out.println("They all trust each other, and give each other the good news as well as the bad news.");
            System.out.println("Everyone collaborates for the common purpose that they have decided to achieve");
        }
    }
}