import java.util.*;

public class TrainBogieUniqueness {

    public static void main(String[] args) {

        System.out.println("================================");
        System.out.println("UC3 - Track Unique Bogie IDs");
        System.out.println("================================");
        System.out.println();

        // Input bogie IDs (some duplicates)
        String[] bogieIds = {"BG104", "BG103", "BG102", "BG101", "BG103", "BG102"};

        // Use HashSet to store unique IDs automatically ignoring duplicates
        Set<String> uniqueBogies = new LinkedHashSet<>();

        for (String id : bogieIds) {
            uniqueBogies.add(id);
        }

        System.out.println("Bogie IDs After Insertion:");
        System.out.println(uniqueBogies);
        System.out.println();
        System.out.println("Note:");
        System.out.println("Duplicates are automatically ignored by HashSet.");
        System.out.println();
        System.out.println("UC3 uniqueness validation completed...");
    }
}