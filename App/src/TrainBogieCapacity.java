import java.util.*;

public class TrainBogieCapacity {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("UC6 - Map Bogie to Capacity (HashMap)");
        System.out.println("========================================");
        System.out.println();

        // Create HashMap to store bogie and capacity
        Map<String, Integer> bogieCapacity = new HashMap<>();

        // Add bogie-capacity mappings
        bogieCapacity.put("First Class", 24);
        bogieCapacity.put("Cargo", 120);
        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 56);

        // Display capacity details
        System.out.println("Bogie Capacity Details:");

        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println();
        System.out.println("UC6 bogie-capacity mapping completed...");
    }
}