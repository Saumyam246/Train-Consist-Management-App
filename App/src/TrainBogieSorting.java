import java.util.*;
import java.util.stream.Collectors;

class Bogie {
    String name;
    int capacity;

    // Constructor
    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
}

public class TrainBogieSorting {

    /**
     * UC7 - Method to Sort Bogies by Capacity
     * Yeh method humne alag se banaya hai taaki Test Case ise call kar sake.
     */
    public List<Bogie> sortBogiesByCapacity(List<Bogie> bogies) {
        if (bogies == null) return new ArrayList<>();

        // Streams use karke sorting (Ascending order: Low to High)
        return bogies.stream()
                .sorted(Comparator.comparingInt(b -> b.capacity))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        TrainBogieSorting app = new TrainBogieSorting();

        System.out.println("========================================");
        System.out.println("UC7 - Sort Bogies by Capacity");
        System.out.println("========================================");

        // List create karna
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        System.out.println("Before Sorting:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        // Method call karke sort karna
        List<Bogie> sortedBogies = app.sortBogiesByCapacity(bogies);

        System.out.println("\nAfter Sorting by Capacity (UC7):");
        for (Bogie b : sortedBogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        System.out.println("\nUC7 sorting completed...");
    }
}