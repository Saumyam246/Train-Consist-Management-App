import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase12TrainConsistMgmntTest {

    private List<Bogie> getSampleBogies() {
        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72, 45.5));
        bogies.add(new Bogie("AC Chair", 56, 42.0));
        bogies.add(new Bogie("First Class", 24, 48.2));
        bogies.add(new Bogie("Sleeper", 70, 45.5));

        return bogies;
    }

    @Test
    void testFunctional_TotalWeightCalculation() {
        double total = UseCase12TrainConsistMgmnt
                .calculateTotal(getSampleBogies(), Bogie::getWeight);

        assertEquals(181.2, total, 0.001);
    }

    @Test
    void testFunctional_EmptyListWeight() {
        double total = UseCase12TrainConsistMgmnt
                .calculateTotal(new ArrayList<>(), Bogie::getWeight);

        assertEquals(0.0, total);
    }

    @Test
    void testFunctional_SingleBogieWeight() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 72, 45.5));

        double total = UseCase12TrainConsistMgmnt
                .calculateTotal(list, Bogie::getWeight);

        assertEquals(45.5, total);
    }

    @Test
    void testFunctional_DynamicAttributeSwitch() {
        // 🔥 SAME method → different logic (capacity instead of weight)
        double totalCapacity = UseCase12TrainConsistMgmnt
                .calculateTotal(getSampleBogies(), b -> b.getCapacity());

        assertEquals(72 + 56 + 24 + 70, totalCapacity);
    }

    @Test
    void testFunctional_PrecisionHandling() {
        double total = UseCase12TrainConsistMgmnt
                .calculateTotal(getSampleBogies(), Bogie::getWeight);

        assertTrue(total > 181.1 && total < 181.3);
    }
}