package classes;

import StrategyClasses.MultipleChoiceQuestion;
import StrategyClasses.OpenQuestion;
import monster.*;
import rooms.*;
import monster.ScopeCreep;
import rooms.ScrumBoard;
import rooms.SprintPlanning;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CLI {
    public static void CLI() {

        Player player = StartGame.createCharacter();


        Monster feedbackPhantom = new Monster(1, 10, "Feedback Phantom", new FeedbackPhantom());
        Monster scopeCreep = new Monster(1, 10, "Scope Creep", new ScopeCreep());
        Monster slowness = new Monster(1, 10, "Slowness", new Slowness());
        Monster stagnator = new Monster(1, 10, "Stagnator", new Stagnator());
        Monster trollo = new Monster(1, 10, "Trollo", new Trollo());
        Monster theScrumReaper = new Monster (1, 25, "Scrum Reaper", new TheScrumReaper());


        Room sprintPlanning = new SprintPlanning("Sprint Planning Room", scopeCreep, false);
        sprintPlanning.setQuestionStrategy(new OpenQuestion("To assign story points to tasks, what is the name of the game you play with the team?"));

        Room theDailyScrum = new TheDailyScrum("The Daily Scrum Room", slowness, false);
        theDailyScrum.setQuestionStrategy(new MultipleChoiceQuestion("What is the main purpose of TheDailyScrum?\n" +
                "A) To report to the Scrum Master.\n" +
                "B) To plant the next sprint.\n" +
                "C) To synchronize and create a plan for then next 24 hours.\n" +
                "D) To assign tasks to developers.\n"));

        Room scrumBoard = new ScrumBoard("Scrumboard Room", trollo, false);
        scrumBoard.setQuestionStrategy(new OpenQuestion("In order to tell the people what to do this day, what is the name of the first thing you should do with this team?\n"));

        Room sprintReview = new SprintReview("Sprint Review Room", feedbackPhantom, false);
        sprintReview.setQuestionStrategy(new MultipleChoiceQuestion("To whom does the Scrum Team show their results during the Sprint Review?\n" +
                "A) To the Scrum Master.\n" +
                "B) Only to the Product Owner.\n" +
                "C) To all the stakeholders.\n" +
                "D) They dont show it to anybody outside the Scrum Team.\n"));

        Room sprintRetrospective = new SprintRetrospective("Sprint Retrospective Room", stagnator, false);
        sprintRetrospective.setQuestionStrategy(new MultipleChoiceQuestion("What can the Scrum Team learn from this experience?\n" +
                "A) The team should work harder\n" +
                "B) The team should regularly involve the stakeholders during Sprint Reviews.\n" +
                "C) That stakeholders don’t understand the technical work anyway, so it’s fine to exclude them.\n" +
                "D) That the Sprint Review is optional and can be skipped if the team is busy.\n"));

        Room tiaRoom = new TIARoom("TIA Room", theScrumReaper, false);
        tiaRoom.setQuestionStrategy(new OpenQuestion("What does the 'T' in TIA stand for?"));


// vaste volgorde van kamers ik word gek btw
        List<Room> allRooms = new ArrayList<>(List.of(
                sprintPlanning,
                theDailyScrum,
                scrumBoard,
                sprintReview,
                sprintRetrospective,
                tiaRoom
        ));


        Game game = new Game(player);
        game.setRooms(allRooms);

// enge for loop voor de obervererers
        for (Room room : allRooms) {
            room.registerObserver(new DeurObserver(room));
            room.registerObserver(new MonsterObserver(room.monster));
            room.registerObserver(new StatusObserver(player, room));
        }

        game.startGame(allRooms.get(0));
    }

}
