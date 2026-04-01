import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



public class TrainBogieFiltering {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("UC8 - Filter Passenger Bogies Using Streams");
        System.out.println("========================================");
        System.out.println();

        // Create list of bogies
        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        // Print all bogies
        System.out.println("All Bogies:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        System.out.println();

        // Filter using Stream
        List<Bogie> filteredBogies = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        // Print filtered bogies
        System.out.println("Filtered Bogies (Capacity > 60):");
        for (Bogie b : filteredBogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        System.out.println();
        System.out.println("UC8 filtering completed...");
    }
}