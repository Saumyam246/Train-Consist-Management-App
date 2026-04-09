import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class TrainServiceTest {

    @Test
    void testReduce_TotalSeatCalculation() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24),
                new Bogie("Sleeper", 70)
        );

        int result = TrainService.calculateTotalSeats(bogies);
        assertEquals(222, result);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("A", 10),
                new Bogie("B", 20),
                new Bogie("C", 30)
        );

        assertEquals(60, TrainService.calculateTotalSeats(bogies));
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> bogies = Collections.singletonList(
                new Bogie("Sleeper", 72)
        );

        assertEquals(72, TrainService.calculateTotalSeats(bogies));
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        assertEquals(0, TrainService.calculateTotalSeats(bogies));
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("X", 5),
                new Bogie("Y", 15)
        );

        assertEquals(20, TrainService.calculateTotalSeats(bogies));
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("A", 1),
                new Bogie("B", 2),
                new Bogie("C", 3),
                new Bogie("D", 4)
        );

        assertEquals(10, TrainService.calculateTotalSeats(bogies));
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>(Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC", 50)
        ));

        List<Bogie> copy = new ArrayList<>(bogies);

        TrainService.calculateTotalSeats(bogies);

        assertEquals(copy.size(), bogies.size());
    }
}