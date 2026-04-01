import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class TrainConsistBogieTest {

    private TrainBogieSorting sortingService;
    private List<Bogie> bogieList;

    @BeforeEach
    void setUp() {
        sortingService = new TrainBogieSorting();
        bogieList = new ArrayList<>();
        // Unsorted data add kar rahe hain check karne ke liye
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("First Class", 24));
        bogieList.add(new Bogie("General", 90));
    }

    @Test
    void testSort_CapacityInAscendingOrder() {
        // Act
        List<Bogie> result = sortingService.sortBogiesByCapacity(bogieList);

        // Assert: Check order (24 -> 56 -> 72 -> 90)
        assertEquals(4, result.size());
        assertEquals(24, result.get(0).capacity);
        assertEquals(56, result.get(1).capacity);
        assertEquals(72, result.get(2).capacity);
        assertEquals(90, result.get(3).capacity);
    }

    @Test
    void testSort_FirstElementIsLowest() {
        List<Bogie> result = sortingService.sortBogiesByCapacity(bogieList);
        assertEquals("First Class", result.get(0).name);
    }

    @Test
    void testSort_LastElementIsHighest() {
        List<Bogie> result = sortingService.sortBogiesByCapacity(bogieList);
        assertEquals("General", result.get(3).name);
    }

    @Test
    void testSort_EmptyListReturnsEmpty() {
        List<Bogie> result = sortingService.sortBogiesByCapacity(new ArrayList<>());
        assertTrue(result.isEmpty());
    }

    @Test
    void testSort_NullListReturnsEmpty() {
        List<Bogie> result = sortingService.sortBogiesByCapacity(null);
        assertTrue(result.isEmpty());
    }

    @Test
    void testSort_SingleBogieList() {
        List<Bogie> single = new ArrayList<>();
        single.add(new Bogie("Sleeper", 72));
        List<Bogie> result = sortingService.sortBogiesByCapacity(single);
        assertEquals(1, result.size());
        assertEquals(72, result.get(0).capacity);
    }

    @Test
    void testSort_OriginalListUnchanged() {
        int initialSize = bogieList.size();
        sortingService.sortBogiesByCapacity(bogieList);

        // Original list ka order change nahi hona chahiye (Stream rule)
        assertEquals(initialSize, bogieList.size());
        assertEquals("Sleeper", bogieList.get(0).name);
    }

    @Test
    void testSort_DuplicateCapacities() {
        bogieList.add(new Bogie("Extra", 56)); // Ek aur 56 capacity wala add kiya
        List<Bogie> result = sortingService.sortBogiesByCapacity(bogieList);
        assertEquals(5, result.size());
        // Dono 56 wale sath mein hone chahiye
        assertEquals(56, result.get(1).capacity);
        assertEquals(56, result.get(2).capacity);
    }
}