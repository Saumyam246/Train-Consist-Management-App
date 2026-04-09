import java.util.regex.Pattern;

public class CargoValidator {

    // Regex Explained:
    // ^TRN- : Starts with literal "TRN-"
    // \\d{4} : Followed by exactly 4 digits
    // $ : End of string (ensures exact match)
    private static final String TRAIN_ID_REGEX = "^TRN-\\d{4}$";

    // Regex Explained:
    // ^PET- : Starts with literal "PET-"
    // [A-Z]{2} : Followed by exactly 2 uppercase letters
    // $ : End of string
    private static final String CARGO_CODE_REGEX = "^PET-[A-Z]{2}$";

    public static boolean validateTrainID(String trainID) {
        if (trainID == null) return false;
        return Pattern.matches(TRAIN_ID_REGEX, trainID);
    }

    public static boolean validateCargoCode(String cargoCode) {
        if (cargoCode == null) return false;
        return Pattern.matches(CARGO_CODE_REGEX, cargoCode);
    }
}