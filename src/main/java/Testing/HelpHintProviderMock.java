package Testing;

import FactoryClasses.HelpHintProvider;
import classes.Room;
import rooms.SprintPlanning;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class HelpHintProviderMock {

 Room room = new SprintPlanning(null,false,null,null);
 HelpHintProviderMock mock = new HelpHintProviderMock(room);

 String hint = mock.getHint();

 assertEquals('This is the mockhint!', hint);
