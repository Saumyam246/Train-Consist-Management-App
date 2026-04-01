import java.util.*;

public class TrainBogieFormation {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("UC5 - Preserve Insertion Order of Bogies");
        System.out.println("========================================");
        System.out.println();

        // Create LinkedHashSet to maintain order + uniqueness
        Set<String> trainFormation = new LinkedHashSet<>();

        // Add bogies
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        // Attempt to add duplicate
        trainFormation.add("Sleeper"); // will be ignored

        // Display final formation
        System.out.println("Final Train Formation:");
        System.out.println(trainFormation);
        System.out.println();

        System.out.println("Note:");
        System.out.println("LinkedHashSet preserves insertion order and removes duplicates automatically.");
        System.out.println();

        System.out.println("UC5 formation setup completed...");
    }
}