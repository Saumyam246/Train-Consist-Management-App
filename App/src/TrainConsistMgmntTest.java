import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TrainConsistMgmntTest {

    @Test
    void testException_ValidCapacityCreation() throws TrainConsistMgmnt.InvalidCapacityException {
        TrainConsistMgmnt.PassengerBogie bogie =
                new TrainConsistMgmnt.PassengerBogie("Sleeper", 72);

        assertNotNull(bogie);
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        assertThrows(
                TrainConsistMgmnt.InvalidCapacityException.class,
                () -> new TrainConsistMgmnt.PassengerBogie("Sleeper", -10)
        );
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        assertThrows(
                TrainConsistMgmnt.InvalidCapacityException.class,
                () -> new TrainConsistMgmnt.PassengerBogie("Sleeper", 0)
        );
    }

    @Test
    void testException_ExceptionMessageValidation() {
        Exception exception = assertThrows(
                TrainConsistMgmnt.InvalidCapacityException.class,
                () -> new TrainConsistMgmnt.PassengerBogie("Sleeper", 0)
        );

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws TrainConsistMgmnt.InvalidCapacityException {
        TrainConsistMgmnt.PassengerBogie bogie =
                new TrainConsistMgmnt.PassengerBogie("Sleeper", 50);

        assertEquals("Sleeper", bogie.type);
        assertEquals(50, bogie.capacity);
    }

    @Test
    void testException_MultipleValidBogiesCreation() throws TrainConsistMgmnt.InvalidCapacityException {
        TrainConsistMgmnt.PassengerBogie bogie1 =
                new TrainConsistMgmnt.PassengerBogie("Sleeper", 60);

        TrainConsistMgmnt.PassengerBogie bogie2 =
                new TrainConsistMgmnt.PassengerBogie("AC Chair", 80);

        assertNotNull(bogie1);
        assertNotNull(bogie2);
    }
}