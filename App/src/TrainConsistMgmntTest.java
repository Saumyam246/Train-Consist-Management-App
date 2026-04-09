import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TrainConsistMgmntTest {

    @Test
    void testCargo_SafeAssignment() {
        TrainConsistMgmnt.GoodsBogie bogie =
                new TrainConsistMgmnt.GoodsBogie("Cylindrical");

        bogie.assignCargo("Petroleum");

        assertEquals("Petroleum", bogie.cargo);
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        TrainConsistMgmnt.GoodsBogie bogie =
                new TrainConsistMgmnt.GoodsBogie("Rectangular");

        bogie.assignCargo("Petroleum");

        assertNull(bogie.cargo);
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        TrainConsistMgmnt.GoodsBogie bogie =
                new TrainConsistMgmnt.GoodsBogie("Rectangular");

        bogie.assignCargo("Petroleum");

        assertNull(bogie.cargo);
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        TrainConsistMgmnt.GoodsBogie bogie1 =
                new TrainConsistMgmnt.GoodsBogie("Rectangular");

        TrainConsistMgmnt.GoodsBogie bogie2 =
                new TrainConsistMgmnt.GoodsBogie("Cylindrical");

        bogie1.assignCargo("Petroleum");
        bogie2.assignCargo("Coal");

        assertEquals("Coal", bogie2.cargo);
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        TrainConsistMgmnt.GoodsBogie bogie =
                new TrainConsistMgmnt.GoodsBogie("Rectangular");

        bogie.assignCargo("Petroleum");

        assertNull(bogie.cargo); // finally always runs, cargo remains null
    }
}