import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase13TrainConsistMgmntTest {

    private List<Bogie> getSampleBogies() {
        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72, 45.5));
        bogies.add(new Bogie("AC Chair", 56, 42.0));
        bogies.add(new Bogie("First Class", 24, 48.2));
        bogies.add(new Bogie("Sleeper", 70, 45.5));

        return bogies;
    }

    @Test
    void testMax_FindHeaviestBogie() {
        Optional<Bogie> result =
                UseCase13TrainConsistMgmnt.findHeaviestBogie(getSampleBogies());

        assertTrue(result.isPresent());
        assertEquals(48.2, result.get().getWeight());
    }

    @Test
    void testMax_EmptyListHandling() {
        Optional<Bogie> result =
                UseCase13TrainConsistMgmnt.findHeaviestBogie(new ArrayList<>());

        assertFalse(result.isPresent());
    }

    @Test
    void testMax_SingleBogieResult() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 72, 45.5));

        Optional<Bogie> result =
                UseCase13TrainConsistMgmnt.findHeaviestBogie(list);

        assertTrue(result.isPresent());
        assertEquals(45.5, result.get().getWeight());
    }

    @Test
    void testMax_MultipleBogiesSameWeight() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("A", 10, 50.0));
        list.add(new Bogie("B", 20, 50.0));

        Optional<Bogie> result =
                UseCase13TrainConsistMgmnt.findHeaviestBogie(list);

        assertTrue(result.isPresent());
        assertEquals(50.0, result.get().getWeight());
    }

    @Test
    void testMax_OptionalPresenceCheck() {
        Optional<Bogie> result =
                UseCase13TrainConsistMgmnt.findHeaviestBogie(getSampleBogies());

        assertTrue(result.isPresent());
    }

    @Test
    void testMax_CorrectWeightExtraction() {
        Optional<Bogie> result =
                UseCase13TrainConsistMgmnt.findHeaviestBogie(getSampleBogies());

        assertEquals("First Class", result.get().getName());
    }

    @Test
    void testMax_OriginalListUnchanged() {
        List<Bogie> original = getSampleBogies();

        UseCase13TrainConsistMgmnt.findHeaviestBogie(original);

        assertEquals(4, original.size());
    }
}