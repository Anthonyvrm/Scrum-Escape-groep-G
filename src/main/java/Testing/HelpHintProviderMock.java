package Testing;

import FactoryClasses.HelpHintProvider;
import classes.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rooms.SprintPlanning;

import static org.junit.jupiter.api.Assertions.*;

public class HelpHintProviderMock {
    private Room room;
    private HelpHintProvider mockProvider;

    @BeforeEach
    void setUp() {
        room = new SprintPlanning(null, false, null, null) {

         @Override
         public String getHelpHint() {
          return "This is the mockhint!";

            }
        };

        mockProvider = new HelpHintProvider(room) {
            @Override
            public String getHint() {
                return "This is the mockhint!";
            }
        };
    }

    @Test
    void testGetHint() {
        // Act
        String hint = mockProvider.getHint();

        // Assert
        assertNotNull(hint, "Hint should not be null");
        assertEquals("This is the mockhint!", hint);
    }
}