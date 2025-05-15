package classes;

import monster.*;
import rooms.*;

import java.util.Scanner;

public class CLI {
    public static void CLI() {

        Player player = new Player();
        player.createCharacter();

        monster.FeedbackPhantom feedbackPhantom = new FeedbackPhantom(1,10);
        monster.ScopeCreep scopeCreep = new ScopeCreep(1, 10);
        monster.Slowness slowness = new Slowness(1, 10);
        monster.Stagnator stagnator = new Stagnator(1, 10);
        monster.Trollo trollo = new Trollo(1, 10);
        monster.TheScrumReaper TheScrumReaper = new TheScrumReaper(1, 25);

        rooms.ScrumBoard scrumBoard = new ScrumBoard("Scrumboard Room", trollo, false);
        rooms.SprintPlanning sprintPlanning = new SprintPlanning("Sprint Planning Room", scopeCreep, false);
        rooms.SprintRetrospective sprintRetrospective = new SprintRetrospective("Sprint Retrospective Room", stagnator, false);
        rooms.SprintReview sprintReview = new SprintReview("Sprint Review Room", feedbackPhantom, false);
        rooms.TheDailyScrum theDailyScrum = new TheDailyScrum("The Daily Scrum Room", slowness, false);
        rooms.TIARoom tiaRoom = new TIARoom("TIA Room", TheScrumReaper, false);

        scrumBoard.registerObserver(new DeurObserver(scrumBoard));
        theDailyScrum.registerObserver(new DeurObserver(theDailyScrum));
        sprintRetrospective.registerObserver(new DeurObserver(sprintRetrospective));
        sprintReview.registerObserver(new DeurObserver(sprintReview));
        sprintPlanning.registerObserver(new DeurObserver(sprintPlanning));
        theDailyScrum.registerObserver(new DeurObserver(theDailyScrum));
        tiaRoom.registerObserver(new DeurObserver(tiaRoom));

        Game game = new Game(player);
        game.startGame(sprintPlanning);



        





    }

}

