import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

class CargoValidatorTest {

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(CargoValidator.validateTrainID("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(CargoValidator.validateTrainID("TRAIN12"));
        assertFalse(CargoValidator.validateTrainID("TRN12A"));
        assertFalse(CargoValidator.validateTrainID("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(CargoValidator.validateCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(CargoValidator.validateCargoCode("PET-ab")); // Lowercase check
        assertFalse(CargoValidator.validateCargoCode("PET123")); // Number check
        assertFalse(CargoValidator.validateCargoCode("AB-PET")); // Order check
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(CargoValidator.validateTrainID("TRN-123"));   // Too short
        assertFalse(CargoValidator.validateTrainID("TRN-12345")); // Too long
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(CargoValidator.validateCargoCode("PET-aB"));
        assertFalse(CargoValidator.validateCargoCode("PET-xy"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(CargoValidator.validateTrainID(""));
        assertFalse(CargoValidator.validateCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        // Verifies no extra characters are allowed before or after
        assertFalse(CargoValidator.validateTrainID("TRN-1234 "));
        assertFalse(CargoValidator.validateCargoCode("PET-AB-EXTRA"));
    }
}